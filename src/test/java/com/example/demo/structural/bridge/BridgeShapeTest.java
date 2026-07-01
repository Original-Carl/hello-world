package com.example.demo.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeShapeTest {

    @Test
    void circle_withSvgApi_outputContainsSvg() {
        BridgeCircle circle = new BridgeCircle(0, 0, 5, new SvgDrawingAPI());
        assertThat(circle.draw()).containsIgnoringCase("svg");
    }

    @Test
    void circle_withCanvasApi_outputContainsCanvas() {
        BridgeCircle circle = new BridgeCircle(0, 0, 5, new CanvasDrawingAPI());
        assertThat(circle.draw()).containsIgnoringCase("canvas");
    }

    @Test
    void rectangle_withSvgApi_outputContainsSvg() {
        BridgeRectangle rect = new BridgeRectangle(0, 0, 10, 5, new SvgDrawingAPI());
        assertThat(rect.draw()).containsIgnoringCase("svg");
    }

    @Test
    void rectangle_withCanvasApi_outputContainsCanvas() {
        BridgeRectangle rect = new BridgeRectangle(0, 0, 10, 5, new CanvasDrawingAPI());
        assertThat(rect.draw()).containsIgnoringCase("canvas");
    }

    @Test
    void swappingApi_changesCircleOutput() {
        BridgeCircle circle = new BridgeCircle(0, 0, 5, new SvgDrawingAPI());
        String svgOutput = circle.draw();
        circle.setApi(new CanvasDrawingAPI());
        String canvasOutput = circle.draw();
        assertThat(svgOutput).isNotEqualTo(canvasOutput);
    }

    @Test
    void noNewSubclassNeeded_fourCombinationsFromTwoClassesTimesTwoApis() {
        DrawingAPI svg = new SvgDrawingAPI();
        DrawingAPI canvas = new CanvasDrawingAPI();
        assertThat(new BridgeCircle(0, 0, 1, svg).draw()).containsIgnoringCase("svg");
        assertThat(new BridgeCircle(0, 0, 1, canvas).draw()).containsIgnoringCase("canvas");
        assertThat(new BridgeRectangle(0, 0, 1, 1, svg).draw()).containsIgnoringCase("svg");
        assertThat(new BridgeRectangle(0, 0, 1, 1, canvas).draw()).containsIgnoringCase("canvas");
    }
}
