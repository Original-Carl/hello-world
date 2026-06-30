package com.example.demo.structural.composite;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompositeFileSystemTest {

    @Test
    void file_name_returnsName() {
        FileLeaf file = new FileLeaf("readme.txt", 1024);
        assertThat(file.name()).isEqualTo("readme.txt");
    }

    @Test
    void file_size_returnsSize() {
        FileLeaf file = new FileLeaf("readme.txt", 1024);
        assertThat(file.size()).isEqualTo(1024);
    }

    @Test
    void emptyDirectory_size_isZero() {
        FileDirectory dir = new FileDirectory("empty");
        assertThat(dir.size()).isZero();
    }

    @Test
    void directory_size_sumsImmediateChildren() {
        FileDirectory dir = new FileDirectory("docs");
        dir.add(new FileLeaf("a.txt", 100));
        dir.add(new FileLeaf("b.txt", 200));
        assertThat(dir.size()).isEqualTo(300);
    }

    @Test
    void nestedDirectories_size_isRecursive() {
        FileDirectory root = new FileDirectory("root");
        FileDirectory sub = new FileDirectory("sub");
        sub.add(new FileLeaf("deep.txt", 500));
        root.add(new FileLeaf("top.txt", 100));
        root.add(sub);
        assertThat(root.size()).isEqualTo(600);
    }

    @Test
    void clientCode_treatsLeafAndCompositeUniformly() {
        List<FileComponent> components = List.of(
                new FileLeaf("a.txt", 10),
                new FileLeaf("b.txt", 20)
        );
        long total = components.stream().mapToLong(FileComponent::size).sum();
        assertThat(total).isEqualTo(30);
    }
}
