package com.example.demo.structural.proxy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProxyImageTest {

    @Test
    void proxy_doesNotLoadOnConstruction() {
        ProxyImage proxy = new ProxyImage("photo.jpg");
        assertThat(proxy.loadCount()).isZero();
    }

    @Test
    void proxy_loadsOnFirstDisplay() {
        ProxyImage proxy = new ProxyImage("photo.jpg");
        proxy.display();
        assertThat(proxy.loadCount()).isEqualTo(1);
    }

    @Test
    void proxy_doesNotReloadOnSubsequentDisplays() {
        ProxyImage proxy = new ProxyImage("photo.jpg");
        proxy.display();
        proxy.display();
        proxy.display();
        assertThat(proxy.loadCount()).isEqualTo(1);
    }

    @Test
    void proxy_displaysCorrectContent() {
        ProxyImage proxy = new ProxyImage("photo.jpg");
        String output = proxy.display();
        assertThat(output).contains("photo.jpg");
    }

    @Test
    void proxy_implementsSameInterface() {
        ProxyImage proxy = new ProxyImage("photo.jpg");
        assertThat(proxy).isInstanceOf(ImageLoader.class);
    }
}
