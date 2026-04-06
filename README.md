# Thesis prototype

## Mill tasks

- `./mill compile`
- `./mill -w compile`
- `./mill run`
- `./mill test.test`
- `./mill compile` (includes Berkeley HardFloat sources from `hardfloat/hardfloat/src/main/scala`)
- `./mill mill.scalalib.scalafmt/reformatAll`
- `./mill mill.scalalib.scalafmt/checkFormatAll`
- `./mill __.fix`

## HardFloat example

- Minimal example module: `src/HardFloatAdd32Example.scala`
- Emits Verilog through `src/Main.scala`
