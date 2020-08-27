package com.example.demo.readinglist;

import com.example.demo.readinglist.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Reader;
import java.util.List;

//@Conditional(JdbcTemplateCondition.class)
@Controller
@RequestMapping("/books")
@ConfigurationProperties(prefix = "vk")

public class ReadingListController {

    private String vkID;
    private int vkID2;

    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    public void setVkID(String vkID) {
        this.vkID = vkID;
    }

    public void setVkID2(int vkID2) {
        this.vkID2 = vkID2;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Model model) {

        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("vkID", vkID);
            model.addAttribute("vkID2", vkID2);

        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList( Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/books";
    }

}