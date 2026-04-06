package prototype

import chisel3._

import hardfloat._

class HF32Add extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val sub = Input(Bool())
    val out = Output(UInt(32.W))
    val exceptionFlags = Output(UInt(5.W))
  })

  val expWidth = 8
  val sigWidth = 24

  val addRecFN = Module(new AddRecFN(expWidth, sigWidth))
  addRecFN.io.subOp := io.sub
  addRecFN.io.a := recFNFromFN(expWidth, sigWidth, io.a)
  addRecFN.io.b := recFNFromFN(expWidth, sigWidth, io.b)
  addRecFN.io.roundingMode := consts.round_near_even
  addRecFN.io.detectTininess := consts.tininess_afterRounding.asBool

  io.out := fNFromRecFN(expWidth, sigWidth, addRecFN.io.out)
  io.exceptionFlags := addRecFN.io.exceptionFlags
}
