package com.olehpodolin.recipeproject.services;

import com.olehpodolin.recipeproject.commands.UnitOfMeasureCommand;
import com.olehpodolin.recipeproject.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.olehpodolin.recipeproject.domain.UnitOfMeasure;
import com.olehpodolin.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureService(UnitOfMeasureRepository unitOfMeasureRepository,
                                UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    public UnitOfMeasure getUnitOfMeasure(String description) {
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom(description);
        if(!unitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("Unit Of Measure Not Found!!!");
        }
        return unitOfMeasureOptional.get();
    }

    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }

}
