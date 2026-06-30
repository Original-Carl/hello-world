package com.example.demo.structural.flyweight;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GlyphFactoryTest {

    @Test
    void sameIntrinsicState_returnsSameInstance() {
        GlyphFactory factory = new GlyphFactory();
        CharGlyph g1 = factory.getGlyph('A', "Arial", "black");
        CharGlyph g2 = factory.getGlyph('A', "Arial", "black");
        assertThat(g1).isSameAs(g2);
    }

    @Test
    void differentSymbol_returnsDifferentInstance() {
        GlyphFactory factory = new GlyphFactory();
        CharGlyph gA = factory.getGlyph('A', "Arial", "black");
        CharGlyph gB = factory.getGlyph('B', "Arial", "black");
        assertThat(gA).isNotSameAs(gB);
    }

    @Test
    void differentFont_returnsDifferentInstance() {
        GlyphFactory factory = new GlyphFactory();
        CharGlyph g1 = factory.getGlyph('A', "Arial", "black");
        CharGlyph g2 = factory.getGlyph('A', "Times", "black");
        assertThat(g1).isNotSameAs(g2);
    }

    @Test
    void cachedCount_doesNotGrowOnRepeatRequests() {
        GlyphFactory factory = new GlyphFactory();
        factory.getGlyph('X', "Arial", "red");
        factory.getGlyph('X', "Arial", "red");
        factory.getGlyph('X', "Arial", "red");
        assertThat(factory.cachedCount()).isEqualTo(1);
    }

    @Test
    void render_includesExtrinsicPosition() {
        GlyphFactory factory = new GlyphFactory();
        CharGlyph g = factory.getGlyph('Z', "Arial", "blue");
        String rendered = g.render(10, 20);
        assertThat(rendered).contains("10").contains("20");
    }

    @Test
    void manyRenders_fewCachedInstances() {
        GlyphFactory factory = new GlyphFactory();
        char[] chars = {'A', 'B', 'C'};
        for (int i = 0; i < 100; i++) {
            factory.getGlyph(chars[i % 3], "Arial", "black").render(i, i);
        }
        assertThat(factory.cachedCount()).isEqualTo(3);
    }
}
