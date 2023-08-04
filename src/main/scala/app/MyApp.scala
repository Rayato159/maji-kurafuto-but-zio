package app

// Internal package
import pkg.db.Db

// Internal Modules
import modules.maji.Maji

import zio._
import zhttp.http._
import zhttp.service.Server
import zio.json._

object MyApp extends ZIOAppDefault:
  // Create HTTP route
  private def appHttp(): Http[Any, Nothing, Request, Response] =
    Http.collect[Request] {
//      case req@(Method.GET -> !! / "greet") if (req.url.queryParams.nonEmpty) =>
//        Response.text(s"Hello ${req.url.queryParams("name").mkString(" and ")}!")
//
//      case Method.GET -> !! / "greet" =>
//        Response.text(s"Hello World!")

      case Method.GET -> !! / "maji" / majiId =>
        Response.json(
          Maji(
            1,
            "Thunder Sword",
            "To generate a thunder storm power and hits all targets",
            120,
          ).toJson
        ).setStatus(Status.Ok)
    }

  override val run: ZIO[Any, Throwable, Nothing] =
    Server.start(
      port = 8080,
      http = appHttp()
    )