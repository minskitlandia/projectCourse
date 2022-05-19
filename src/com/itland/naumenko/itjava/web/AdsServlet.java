package com.itland.naumenko.itjava.web;

import com.itland.naumenko.itjava.dao.AdsDao;
import com.itland.naumenko.itjava.dao.AdsDaoImpl;
import com.itland.naumenko.itjava.model.Ads;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="AdsServlet", urlPatterns = "/ads")
public class AdsServlet extends HttpServlet {

    AdsDao adsDao;

    public AdsServlet(){
        this.adsDao = new AdsDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ads> ads = adsDao.getAllAds();
        req.setAttribute("ads", ads);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ads.jsp");
        dispatcher.forward(req,resp);
    }


}
