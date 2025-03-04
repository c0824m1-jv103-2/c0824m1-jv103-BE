package com.example.module3.controller;

import com.example.module3.commonUtils.CommonUtils;
import com.example.module3.entity.KhenThuong;
import com.example.module3.entity.NhanVien;
import com.example.module3.entity.PhongBan;
import com.example.module3.service.KhenThuongService;
import com.example.module3.service.NhanVienService;
import com.example.module3.service.PhongBanService;
import com.example.module3.service.imp.IKhenThuongService;
import com.example.module3.service.imp.INhanVienService;
import com.example.module3.service.imp.IPhongBanService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PhongBanController", urlPatterns = "/phongban")
public class PhongBanController extends HttpServlet {
    private final IPhongBanService phongBanService = new PhongBanService();
    private final INhanVienService nhanVienService = new NhanVienService();
    private final IKhenThuongService khenThuongService = new KhenThuongService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "loaiKhenThuong":
                loaiKhenThuong(req, resp);
                break;
            case "khenThuong":
                khenThuongList(req, resp);
                break;
            case "deleteKhenThuong":
                deleteKhenThuong(req, resp);
                break;
            case "createKhenThuong":
                List<NhanVien> nhanViens = nhanVienService.findAllMaNV();
                req.setAttribute("nhanViens", nhanViens);
                req.getRequestDispatcher("/QuanLy/CreateKhenThuong.jsp").forward(req, resp);
                break;
            case "UpdateNhanVien":
                updateNhanVien(req, resp);
                break;
            case "createNhanVien":
                createNhanVien(req, resp);
                break;
            default:
                phongBan(req, resp);
                break;
        }
    }

    private void loaiKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhenThuong> khenThuongs;
        String loai = req.getParameter("id");
        if (loai == null || loai.isEmpty()) {
            khenThuongs = khenThuongService.getKhenThuongList();
        } else {
            khenThuongs = khenThuongService.findByLoai(loai);
        }
        for (KhenThuong khenThuong : khenThuongs) {
            khenThuong.setSoTienFormatted(CommonUtils.formatVND(khenThuong.getSoTien()));
            khenThuong.setNgayFormatted(CommonUtils.formatDate(khenThuong.getNgay()));
        }
        req.setAttribute("khenThuongs", khenThuongs);
        req.getRequestDispatcher("/QuanLy/KhenThuong.jsp").forward(req, resp);
    }

    private void deleteKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Ma = Integer.parseInt(req.getParameter("id"));
        khenThuongService.remove(Ma);
        khenThuongList(req, resp);
    }


    private void khenThuongList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhenThuong> khenThuongs = khenThuongService.getKhenThuongList();
        for (KhenThuong khenThuong : khenThuongs) {
            khenThuong.setSoTienFormatted(CommonUtils.formatVND(khenThuong.getSoTien()));
            khenThuong.setNgayFormatted(CommonUtils.formatDate(khenThuong.getNgay()));
        }
        req.setAttribute("khenThuongs", khenThuongs);
        req.getRequestDispatcher("/QuanLy/KhenThuong.jsp").forward(req, resp);
    }

    private void updateNhanVien(HttpServletRequest req, HttpServletResponse resp) {
        List<PhongBan> phongBanList = phongBanService.getPhongBanList();
        req.setAttribute("PhongBanList", phongBanList);
        int MaNV = Integer.parseInt(req.getParameter("MaNV"));
        String TenPhongBan = req.getParameter("tenphongban");
        NhanVien nhanVien = nhanVienService.updateNhanVien(MaNV);
        PhongBan phongBan = phongBanService.getPhongBan(TenPhongBan);
        req.setAttribute("phongBan", phongBan);
        req.setAttribute("nhanvien", nhanVien);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/UpdateNhanVien.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNhanVien(HttpServletRequest req, HttpServletResponse resp) {
        List<PhongBan> phongBanList = phongBanService.getPhongBanList();
        req.setAttribute("nhanVienList", phongBanList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/createNhanVien.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createKhenThuong":
                createKhenThuong(req, resp);
                break;
            case "searchPhongBan":
                searchPhongBan(req, resp);
                break;
            case "deleteNhanVien":
                Delete(req, resp);
                break;
            case "createNhanVien2":
                CreateNhanVien(req, resp);
                break;
            case "updateNhanVien":
                update(req, resp);
                break;
        }
    }

    private void createKhenThuong(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int Ma = Integer.parseInt(req.getParameter("Ma"));
        String Loai = req.getParameter("Loai");
        float SoTien = Float.parseFloat(req.getParameter("SoTien"));
        String LyDo = req.getParameter("LyDo");
        LocalDate Ngay = LocalDate.parse(req.getParameter("Ngay"));
        KhenThuong khenThuong = new KhenThuong(Ma, Loai, SoTien, LyDo, Ngay);
        khenThuongService.save(khenThuong);
        req.getSession().setAttribute("message", "Thêm mới thành công");
        resp.sendRedirect("/phongban?action=khenThuong");
    }

    private void CreateNhanVien(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String HoTen = req.getParameter("HoTen");
        LocalDate NgaySinh = LocalDate.parse(req.getParameter("NgaySinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String GioiTinh = req.getParameter("GioiTinh");
        String ChucVu = req.getParameter("ChucVu");
        String Email = req.getParameter("Email");
        String CCCD = req.getParameter("CCCD");
        String TenPhongBan = req.getParameter("TenPhongBan");
        PhongBan phongBan = phongBanService.getPhongBan(TenPhongBan);
        NhanVien nhanVien = new NhanVien(HoTen, NgaySinh, GioiTinh, ChucVu, Email, CCCD, phongBan);
        nhanVienService.createNhanVien(nhanVien);
        try {
            req.getSession().setAttribute("message", "Thêm mới thành công");
            resp.sendRedirect("/phongban");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        nhanVienService.deleteNhanVien(id);
        try {
            resp.sendRedirect("/phongban");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchPhongBan(HttpServletRequest req, HttpServletResponse resp) {
        String tenPhongBan = req.getParameter("tenPhongBan");
        req.setAttribute("tenPhongBan", tenPhongBan);
        List<PhongBan> PhongBan = phongBanService.getPhongBanList();
        req.setAttribute("PhongBan", PhongBan);
        List<NhanVien> NhanViens = nhanVienService.getNhanVien(tenPhongBan);
        for (NhanVien nhanVien : NhanViens) {
            nhanVien.setNgayFormatted(CommonUtils.formatDate(nhanVien.getNgaySinh()));
        }
        req.setAttribute("NhanViens", NhanViens);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/PhongBan.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void phongBan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PhongBan> PhongBan = phongBanService.getPhongBanList();
        req.setAttribute("PhongBan", PhongBan);
        List<NhanVien> NhanViens = nhanVienService.getNhanVien("");
        for (NhanVien nhanVien : NhanViens) {
            nhanVien.setNgayFormatted(CommonUtils.formatDate(nhanVien.getNgaySinh()));
        }
        req.setAttribute("NhanViens", NhanViens);
        RequestDispatcher dispatcher = req.getRequestDispatcher("QuanLy/PhongBan.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {
        int MaNV = Integer.parseInt(req.getParameter("MaNV"));
        String HoTen = req.getParameter("HoTen");
        LocalDate NgaySinh = LocalDate.parse(req.getParameter("NgaySinh"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String GioiTinh = req.getParameter("GioiTinh");
        String ChucVu = req.getParameter("ChucVu");
        String Email = req.getParameter("Email");
        String CCCD = req.getParameter("CCCD");
        String TenPhongBan = req.getParameter("TenPhongBan");
        PhongBan phongBan = phongBanService.getPhongBan(TenPhongBan);
        NhanVien nhanVien = new NhanVien(MaNV, HoTen, NgaySinh, GioiTinh, ChucVu, Email, CCCD, phongBan);
        nhanVienService.update(nhanVien);
        try {
            resp.sendRedirect("/phongban");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

