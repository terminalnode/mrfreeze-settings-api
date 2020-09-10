package xyz.terminalnode.mrfreeze.settings_api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

  @GetMapping
  fun helloWorld(): String {
    return """
    <html>
      <head>
        <title>MrFreeze Settings API</title>
      </head>
      <style>
        body {
          background-color: linen;
          text-align: center;
          width: 400px;
        }
        
        h1 {
          color: cornflowerblue;
        }
        
        p {
          color: cadetblue;
        }
      </style>
      <body>
      <div class="container">
        <h1>It's working!</h2>
        <p>
          Welcome to the MrFreeze Settings API. It would seem that the API is
          up and running and doing just fine. Everything is awesome.
        </p>
      </div>
      </body>
    </html>
    """.trimIndent()
  }
}