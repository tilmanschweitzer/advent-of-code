package de.tilmanschweitzer.adventofcode.puzzle.aoc2016.day08.screen;

import de.tilmanschweitzer.adventofcode.common.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DefaultScreen implements Screen {

    final int width;
    final int height;
    final List<List<ScreenPixel>> pixels;

    private DefaultScreen(int width, int height, List<List<ScreenPixel>> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public static DefaultScreen of(int width, int height) {
        final List<List<ScreenPixel>> pixels = new ArrayList<>();
        Coordinates.coordinateStreamWithinGrid(width, height).forEach(coordinate -> {
            if (coordinate.getY() >= pixels.size()) {
                pixels.add(new ArrayList<>());
            }
            pixels.get(coordinate.getY()).add(ScreenPixel.of(coordinate));
        });
        return new DefaultScreen(width, height, pixels);
    }

    private ScreenPixel getPixel(int x, int y) {
        return pixels.get(y).get(x);
    }

    @Override
    public List<Boolean> getRow(int y) {
        return pixels.get(y).stream().map(ScreenPixel::isOn).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<Boolean> getColumn(int x) {
        return IntStream.range(0, height).boxed().map(y -> getPixel(x, y).isOn()).collect(Collectors.toUnmodifiableList());
    }

    public boolean isOn(int x, int y) {
        return getPixel(x, y).isOn();
    }

    @Override
    public void turnOn(int x, int y) {
        getPixel(x, y).turnOn();
    }

    @Override
    public void setOn(int x, int y, boolean on) {
        getPixel(x, y).setOn(on);
    }

    @Override
    public String toString() {
        return pixels.stream().map(pixelRow -> pixelRow.stream().map(DefaultScreen::displayChar).map(Objects::toString).collect(Collectors.joining()))
                .collect(Collectors.joining("\n"));
    }

    private static char displayChar(ScreenPixel screenPixel) {
        return screenPixel.isOn() ? '#' : '.';
    }


    @Override
    public long countLights() {
        return pixels.stream().map(row -> row.stream().filter(ScreenPixel::isOn).count()).reduce(Long::sum).orElse(0L);
    }
}
