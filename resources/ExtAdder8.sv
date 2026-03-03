module ExtAdder8 (
    input        clock,
    reset,
    input  [7:0] io_a,
    io_b,
    output [7:0] io_sum
);
  assign io_sum = io_a + io_b;
endmodule
