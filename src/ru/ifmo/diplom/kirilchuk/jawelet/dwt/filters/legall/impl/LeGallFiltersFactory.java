package ru.ifmo.diplom.kirilchuk.jawelet.dwt.filters.legall.impl;

import ru.ifmo.diplom.kirilchuk.jawelet.dwt.filters.Filter;
import ru.ifmo.diplom.kirilchuk.jawelet.dwt.filters.AbstractFiltersFactory;

/**
 * Concrete factory for Haar discrete wavelet transform.
 * 
 * @author Kirilchuk V.E.
 */
public class LeGallFiltersFactory extends AbstractFiltersFactory {

    private static final Filter LOW_DECOMPOSITION_FILTER  = new LeGallLowDecompFilter();
    private static final Filter HI_DECOMPOSITION_FILTER   = new LeGallHighDecompFilter();
    private static final Filter LOW_RECONSTRUCTION_FILTER = new LeGallLowReconstrFilter();
    private static final Filter HI_RECONSTRUCTION_FILTER  = new LeGallHighReconstrFilter();

    public LeGallFiltersFactory() {
        super(LOW_DECOMPOSITION_FILTER,  HI_DECOMPOSITION_FILTER,
              LOW_RECONSTRUCTION_FILTER, HI_RECONSTRUCTION_FILTER); 
    }
}