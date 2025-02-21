/*
 * Copyright (C) from 2022 The Play Framework Contributors <https://github.com/playframework>, 2011-2021 Lightbend Inc. <https://www.lightbend.com>
 */

package play.routes.compiler

import play.twirl.api.Format
import play.twirl.api.BufferedContent

import scala.collection.immutable

/**
 * Twirl scala content type
 */
class ScalaContent(elements: immutable.Seq[ScalaContent], text: String)
    extends BufferedContent[ScalaContent](elements, text) {
  def this(text: String) = this(Nil, text)
  def this(elements: immutable.Seq[ScalaContent]) = this(elements, "")

  def contentType = "application/scala"
}

/**
 * Twirl Scala format
 */
object ScalaFormat extends Format[ScalaContent] {
  def raw(text: String) = new ScalaContent(text)

  def escape(text: String) = new ScalaContent(text)

  val empty = new ScalaContent(Nil)

  def fill(elements: immutable.Seq[ScalaContent]) = new ScalaContent(elements)
}
