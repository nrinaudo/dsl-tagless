package json

enum Json:
  case Num(value: Int)
  case Str(value: String)
  case Bool(value: Boolean)
  case Obj(values: Map[String, Json])
  case Arr(values: List[Json])

  def as[A](using d: Decoder[A]): Either[String, A] = d.decode(this)

  override def toString = format(0)

  def padd(length: Int): String = (0 until length).foldLeft("") { case (acc, _) => acc + " " }

  def format(padding: Int): String = this match
    case Json.Num(value)  => value.toString
    case Json.Str(value)  => s""""$value""""
    case Json.Bool(value) => value.toString
    case Json.Obj(values) =>
      values.map { case (key, value) =>
        s"""${padd(padding + 2)}"$key": ${value.format(padding + 2)}"""
      }.mkString("{\n", "\n", s"\n${padd(padding)}}")
    case Json.Arr(values) => values.map(_.format(padding + 2)).mkString("[", ", ", "]")

object Json:
  object Obj:
    def apply(entries: (String, Json)*): Json                          = Json.Obj(entries.toMap)
    private[json] def unapply(json: Json.Obj): Some[Map[String, Json]] = Some(json.values)
    def unapplySeq(json: Json): Option[Seq[(String, Json)]] = json match
      case Json.Obj(entries) => Some(entries.toSeq)
      case _                 => None

  object Arr:
    def apply[A: Encoder](as: A*): Json                         = Json.Arr(as.map(_.asJson).toList)
    private[json] def unapply(json: Json.Arr): Some[List[Json]] = Some(json.values)

    def unapplySeq(json: Json): Option[Seq[Json]] = json match
      case Json.Arr(values) => Some(values)
      case _                => None

@FunctionalInterface
trait Encoder[A]:
  def encode(a: A): Json
  extension (a: A) def asJson: Json = encode(a)

given Encoder[Json] with
  def encode(json: Json) = json

given [A: Encoder]: Encoder[List[A]] with
  def encode(as: List[A]) = Json.Arr(as.map(_.asJson))

given Encoder[Int] with
  def encode(i: Int) = Json.Num(i)

given Encoder[String] with
  def encode(s: String) = Json.Str(s)

given Encoder[Boolean] with
  def encode(b: Boolean) = Json.Bool(b)

@FunctionalInterface
trait Decoder[A]:
  def decode(json: Json): Either[String, A]

given Decoder[Int] with
  def decode(json: Json) = json match
    case Json.Num(i) => Right(i)
    case other       => Left(s"Not a valid number: $other")

given Decoder[Boolean] with
  def decode(json: Json) = json match
    case Json.Bool(b) => Right(b)
    case other        => Left(s"Not a valid boolean: $other")
