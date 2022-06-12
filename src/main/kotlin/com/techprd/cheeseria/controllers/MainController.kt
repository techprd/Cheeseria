package com.techprd.cheeseria.controllers

import org.springframework.context.support.GenericApplicationContext
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.io.IOException
import java.util.*

/**
 * Author: Ali Shirzad
 */
@Controller
class MainController {
    /**
     * aggregates all static files compile from frontend app from class path
     * and injects them into main html file
     * returns the main html page
     *
     * @param model                   model containing static file to inject into html file
     * @param resourcePatternResolver
     * @return main html page that runs the single page app
     * @throws IOException throws if the html file or static file don't exists
     */
    @RequestMapping("/ui/**")
    @Throws(IOException::class)
    fun indexRouting(model: Model, resourcePatternResolver: GenericApplicationContext): String {
        val resources = resourcePatternResolver.getResources("classpath*:/public/static/**/*")
        val jsFiles: MutableList<String> = LinkedList()
        val cssFiles: MutableList<String> = LinkedList()
        for (resource in resources) {
            if (resource.filename != null && resource.filename!!.endsWith(".css")) {
                cssFiles.add("/static/css/" + resource.filename)
            } else if (resource.filename != null && resource.filename!!.endsWith(".js")) {
                jsFiles.add("/static/js/" + resource.filename)
            }
        }
        model.addAttribute("cssFiles", cssFiles)
        model.addAttribute("jsFiles", jsFiles)

        return "index.html"
    }
}
