#!/bin/sh
#java -jar target/benchmarks.jar -f 1 -i 3 -wi 3 MyBenchmark
#java -jar target/benchmarks.jar -f 1 -i 100 -wi 10 RandomAccessFileTest
mvn clean package
#java -jar target/benchmarks.jar -f 1 -i 10 -wi 10 ChannelTest
java -jar target/benchmarks.jar -f 1 -i 10 -wi 10

#java -jar target/benchmarks.jar -i 3 -wi 3
#java -jar target/benchmarks.jar
