object Main extends App {
    println("This class のインスタンスを二つ作ってみる。")
    // This のインスタンスは new されたとたんに this の値を表示する。
    val o1 = new This()
    val o2 = new This()
    println("-" * 70)

    println("オブジェクトへの参照に許された演算は他の参照との identity の確認")
    // (自分 == 自分) => true
    // (自分 == 他人) => false
    println(s"o1 == o1: ${o1 == o1}")
    println(s"o1 == o2: ${o1 == o2}")
    println(s"o1 != o2: ${o1 != o2}")
    println("-" * 70)

    println("上の identity の確認と同じことをもっと多くのオブジェクトを使って再確認する例")
    val objects = Range(0, 10).map(_ => new This())
    val o5 = objects(5)
    objects.zipWithIndex.foreach { case (o, i) => println(s"$i: ${o == o5}")}
    println("-" * 70)

    println(s"Scalaの実行時システムの様子をちょっぴりハックしてみる")
    println(s"o1.toString(): ${o1.toString()}")
    println(s"o1.equals(o1): ${o1.equals(o1)}")
    println(s"o1.equals(o2): ${o1.equals(o2)}")
    println(s"o1.getClass(): ${o1.getClass()}")
    println(s"o1.getClass().getName(): ${o1.getClass().getName()}")
    println(s"o1.hashCode(): ${o1.hashCode()}")
    println(s"o1.hashCode().toHexString: ${o1.hashCode().toHexString}")
    println(s"$o1: ${o1.getClass().getName()}@${o1.hashCode().toHexString}")
}

class This {
    // this は object や class 宣言のなかで使用できる特殊な変数
    // object 宣言のなかの this は object への参照を表す
    // class 宣言のなかの this は class のインスタンスへの参照を表す（つまり、class を new して生まれる object への参照を表す）
    println(this)
}