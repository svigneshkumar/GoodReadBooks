package com.samhad;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class RatingPartitioner extends Partitioner<Text, Text> {


    @Override
    public int getPartition(Text text, Text text2, int numPartitions) {

        String[] valueSplit = text2.toString().split("\trating ");

        if (text.toString().contains("Multi-Writer:")) {
            return 6;
        } else {
            return (int) Float.parseFloat(valueSplit[1]);
        }
    }
}
