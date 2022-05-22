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

@WebServlet(name = "AdsServlet", urlPatterns = {"/ads", "/ads-new", "/ads-add"})
public class AdsServlet extends HttpServlet {

    AdsDao adsDao;

    public AdsServlet() {
        this.adsDao = new AdsDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getServletPath()) {
            case "/ads":
                getAllAds(req, resp);
                break;
            case "/ads-new":
                showAdsForm(req, resp);
                break;
            case "/ads-add":
                addAds(req, resp);
                break;
        }
    }

    private void addAds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.adsDao.insert(Ads.builder()
                .title(req.getParameter("title"))
                .subtitle(req.getParameter("subtitle"))
                .description(req.getParameter("description"))
                .price(Double.parseDouble(req.getParameter("price")))
                .build());
        resp.sendRedirect(req.getContextPath() + "/ads");
    }

    private void showAdsForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ads-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void getAllAds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ads> ads = adsDao.getAllAds();
        req.setAttribute("ads", ads);
        RequestDispatcher dispatcher = req.getRequestDispatcher("ads.jsp");
        dispatcher.forward(req, resp);
    }


}
