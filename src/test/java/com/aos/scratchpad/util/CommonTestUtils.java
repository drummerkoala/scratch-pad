package com.aos.scratchpad.util;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CommonTestUtils {

    EasyRandom gen = getNonRandomGenerator();
    public EasyRandom getRandomGenerator() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters().seed(123L);
        return new EasyRandom(easyRandomParameters);
    }

    public EasyRandom getNonRandomGenerator() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters()
                .randomize(String.class, () -> "1")
                .randomize(Integer.class, () -> 1)
                .randomize(Long.class, () -> 1L)
                .randomize(Float.class, () -> 1F)
                .randomize(Double.class, () -> 1D)
                .randomize(Date.class, () -> new Date(1672520400L))
                .randomize(Boolean.class, () -> Boolean.TRUE)
                .collectionSizeRange(1,1)
                .randomizationDepth(3)
                .ignoreRandomizationErrors(true);
        return new EasyRandom(easyRandomParameters);
    }

    public <T> T objectOf(Class<T> c) {
        return gen.nextObject(c);
    }

    public <T> List<T> listOf(Class<T> c) {
        return Collections.singletonList(gen.nextObject(c));
    }

    public <T> ResponseEntity<T> okResponse(Class<T> c) {
        return new ResponseEntity<>(gen.nextObject(c), HttpStatus.OK);
    }

    public <T> ResponseEntity<List<T>> okListResponse(Class<T> c) {
        return new ResponseEntity<>(Collections.singletonList(gen.nextObject(c)), HttpStatus.OK);
    }

    public <T> ResponseEntity<Void> okVoidResponse(Class<T> c) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public <T> ResponseEntity<T> okResponseWithObject(T o) {
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    public <T> ResponseEntity<List<T>> okListResponseWithObject(T o) {
        return new ResponseEntity<>(Collections.singletonList(o), HttpStatus.OK);
    }
}
