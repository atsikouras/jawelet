package ru.ifmo.diplom.kirilchuk.jawelet.dwt;

import ru.ifmo.diplom.kirilchuk.jawelet.dwt.filters.Filter;

/**
 * Instance of this class corresponding for extending 
 * data sequence on filter length.
 *
 * @author Kirilchuk V.E.
 */
public class Extensioner {

    /**
     * Extends sequence by copying elements from beggining of
     * sequence to the extended end. This method have no side effect,
     * so input array will be unchanged.
     *
     * @param data sequence to extend.
     * @param filter filter to get length for extension.
     * @return extended sequence.
     */
    public double[] extend(double[] data, Filter filter) {
        if(data == null || filter == null) {
            throw new IllegalArgumentException("Args can`t be null.");
        }

        int dataLength   = data.length;
        int filterLength = filter.getCoeff().length;

        double[] result = new double[dataLength + filterLength];
        System.arraycopy(data, 0, result, 0, dataLength);
        System.arraycopy(data, 0, result, dataLength, filterLength);

        return result;
    }
}