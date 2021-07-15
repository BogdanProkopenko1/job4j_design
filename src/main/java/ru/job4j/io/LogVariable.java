package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogVariable {

    private static final Logger LOG = LoggerFactory.getLogger(LogVariable.class.getName());

    public static void main(String[] args) {
        byte bt = 1;
        short st = 2;
        int it = 3;
        long lg = 4;
        float ft = 5.5F;
        double db = 6.5D;
        boolean bl = false;
        char ch = 'a';
        LOG.info("Info byte: {}", bt);
        LOG.info("Info short: {}", st);
        LOG.info("Info int: {}", it);
        LOG.info("Info long: {}", lg);
        LOG.info("Info float: {}", ft);
        LOG.info("Info double: {}", db);
        LOG.info("Info boolean: {}", bl);
        LOG.info("Info ch: {}", ch);
    }
}
