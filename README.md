# Advent of Code

[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/tilmanschweitzer/advent-of-code/Tests)](https://github.com/tilmanschweitzer/advent-of-code/actions/workflows/test.yml)
[![Code Climate maintainability](https://img.shields.io/codeclimate/maintainability/tilmanschweitzer/advent-of-code)](https://codeclimate.com/github/tilmanschweitzer/advent-of-code)
[![Code Climate technical debt](https://img.shields.io/codeclimate/tech-debt/tilmanschweitzer/advent-of-code)](https://codeclimate.com/github/tilmanschweitzer/advent-of-code/issues)
[![Code Climate coverage](https://img.shields.io/codeclimate/coverage/tilmanschweitzer/advent-of-code)](https://codeclimate.com/github/tilmanschweitzer/advent-of-code/code?sort=test_coverage)


> Solutions for advent of code puzzles in Java.

## Usage

Run a puzzle

    # Puzzle of 2017 for day 8 part 2
    ./build-and-run.sh 2017 8 2


## Tests

Run tests

    mvn test

## Architecture tests

Run ArchUnit

    mvn test -PArchUnit
