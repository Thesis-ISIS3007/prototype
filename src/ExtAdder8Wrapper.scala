package prototype

import chisel3._

class ExtAdder8Wrapper extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val sum = Output(UInt(8.W))
  })
  val adder = Module(new ExtAdder8)
  adder.clock := clock
  adder.reset := reset
  adder.io_a := io.a
  adder.io_b := io.b
  io.sum := adder.io_sum
}
