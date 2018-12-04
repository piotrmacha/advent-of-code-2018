# Advent of Code 2018
My solutions to the Advent of Code 2018 (https://adventofcode.com/2018)

This year my target is to solve the problems in Scala using Functional Programming

Each solution is covered by a unit test

## Solutions

### Day 1
#### Part 1
A simple sum of input parameters that reduces to correct value

#### Part 2
Memoization of seen values in a Set and recurssion to iterate throught the input array

### Day 2
#### Part 1
Maps the input to character count map and then counts how many lines meet the requirement

#### Part 2
Counts the differences between inputs and then selects valid two to compute the intersection

### Day 3
Day 3 solutions uses `Region.overlaps(regions: Array<Region>): Array<Region>` to create a list of overlaps between regions

#### Part 1
Creates a list of overlaps then gets individual points then distincts the list and counts its elements

#### Part 2
Searches for a claim that doesn't have any overlaps

### Day 4
In this task a Guard class is created from the event stream. The class provides mehtod
for calculating Array of Sleep Periods and Sleep Periods provide a method for calculating
Array of minutes

#### Part 1
We search for a Guard who slept the most

#### Part 2
We compute the most common sleep minutes with occurrences for all guards and then get the maximum