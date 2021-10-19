package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VypisController {
    private UlozisteInzeratu vypisInzeratu = null;
    /**
     * @return katalog
     */
    public UlozisteInzeratu getVypisInzeratu() {
        return vypisInzeratu;
    }
    /**
     * @param vypisInzeratu katalog, který má být nastaven (injektujeme pomoci anotaci)
     */
    @Autowired
    public void setVypisInzeratu(UlozisteInzeratu vypisInzeratu) {
        this.vypisInzeratu = vypisInzeratu;
    }

    /**
     * Vlastni akce namapovana na danou URL, naplni Model pro JSP a urci logicke jmeno view
     */
    @RequestMapping("/vypis")
    public String hello(){
        return "hello";
    }
    public ModelAndView zobrazit() {
        ModelAndView model = new ModelAndView("vypis");
        model.addObject("inzerat", vypisInzeratu.getInzeraty());
        return model;
    }

}