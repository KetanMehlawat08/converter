package com.example.converter.services;

import com.example.converter.dto.ConverterDto;
import com.example.converter.entities.Converter;
import com.example.converter.repositories.ConverterRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class ConverterService implements IConverterService {

    @Autowired
    private ConverterRepository converterRepository;

    @Override
    public Flux<Converter> getConversion() {
        return converterRepository.findAll();/*.filter(converter -> converter.getStatus().equals(conversionId))*/
    }

    @Override
    public Mono<Converter> createConversion(@RequestBody ConverterDto converterDto){
        var converter = new Converter();
        try
        {
            FileUtils.copyURLToFile(new URL(converterDto.getPdfUrl()), new File("C:/Users/ketan.singh/Documents/Sample/sample.pdf"));
            PDDocument pdf=PDDocument.load(new File("C:/Users/ketan.singh/Documents/Sample/sample.pdf"));
            Writer output=new PrintWriter(converterDto.getConvertedPath());
            new PDFDomTree().writeText(pdf, output);
            output.close();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        Date dt=new Date();

        converter.setConversionId(UUID.randomUUID().toString());
        converter.setStatus("Converted");
        converter.setPdfUrl(converterDto.getPdfUrl());
        converter.setConvertedPath(converterDto.getConvertedPath());
        converter.setCreatedTime(dt.toString());
        converter.setModifiedTime(dt.toString());
        return converterRepository.save(converter);
    }
}
