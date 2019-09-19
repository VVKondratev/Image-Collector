package collect.image.controller;

import collect.image.model.Images;
import collect.image.model.Tags;
import collect.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ImgController {
     private ImageService imgService ;

    @Autowired
    public void setImgService(ImageService imgService) {
        this.imgService = imgService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allImgs() {
        List<Images> imgs = imgService.allImgs();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("imgs");
        modelAndView.addObject("imgsList", imgs);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Images img = imgService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("img", img);
        modelAndView.addObject("img", imgService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editImg(@ModelAttribute("img") Images img) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        imgService.edit(img);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addImg(@ModelAttribute("img") Images img) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        imgService.add(img);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteImg(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Images img = imgService.getById(id);
        imgService.delete(img);
        return modelAndView;
    }

    @RequestMapping(value="/assignedTags/{id}", method = RequestMethod.GET)
    public ModelAndView assignedTags(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        List<Tags> tags = imgService.getTagsById(id);
        modelAndView.setViewName("tags");
        modelAndView.addObject("tagsList", tags);
        return modelAndView;
    }

    @RequestMapping("*")
    @ResponseBody
    public String fallbackMethod(){return "Opps! There is nothing here.";
    }
}
