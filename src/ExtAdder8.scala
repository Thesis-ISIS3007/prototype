package prototype

import chisel3._

class ExtAdder8 extends ExtModule {
  val clock = IO(Input(Clock()))
  val reset = IO(Input(Bool()))
  val io_a = IO(Input(UInt(8.W)))
  val io_b = IO(Input(UInt(8.W)))
  val io_sum = IO(Output(UInt(8.W)))
  addResource("/ExtAdder8.sv")
}
