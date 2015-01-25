namespace java io.artfuldodge.thrift

service Calc {
    i64 add(1: i64 x, 2: i64 y) 
}

struct Foo {
    1: string foo
}
