package me.kdshim.kdd_j.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NiceAdminController {

    @GetMapping("/index.html")
    public String index(){
        return "index";
    }

    @GetMapping("/charts-apex.html")
    public String ChartApexChart(){
        return "charts-apexcharts";
    }

    @GetMapping("/charts-chartjs.html")
    public String ChartChartJS(){
        return "charts-chartjs";
    }

    @GetMapping("/charts-echarts.html")
    public String ChartEchart(){
        return "charts-echarts";
    }

    @GetMapping("/components-accordion.html")
    public String ComponentAccordion(){
        return "components-accordion";
    }

    @GetMapping("/components-badges.html")
    public String ComponentBadges(){
        return "components-badges";
    }

    @GetMapping("/components-breadcrumbs.html")
    public String ComponentsBreadcrumbs(){
        return "components-breadcrumbs";
    }

    @GetMapping("/components-buttons.html")
    public String ComponentButton(){
        return "components-buttons";
    }

    @GetMapping("/components-cards.html")
    public String ComponentsCards(){
        return "components-cards";
    }

    @GetMapping("/components-carousel.html")
    public String ComponentsCarousel(){
        return "components-carousel";
    }

    @GetMapping("/components-list-group.html")
    public String ComponentsListgroup(){
        return "components-list-group";
    }

    @GetMapping("/components-modal.html")
    public String ComponentsModal(){
        return "components-modal";
    }

    @GetMapping("/components-pagination.html")
    public String ComponentsPagination(){
        return "components-pagination";
    }

    @GetMapping("/components-progress.html")
    public String ComponentsProgress(){
        return "components-progress";
    }

    @GetMapping("/components-spinners.html")
    public String ComponentsSpinner(){
        return "components-spinners";
    }

    @GetMapping("/components-tabs.html")
    public String ComponentsTabs(){
        return "components-tabs";
    }

    @GetMapping("/components-tooltips.html")
    public String ComponentsTooltips(){
        return "components-tooltips";
    }

    @GetMapping("/forms-editors.html")
    public String FormEditors(){
        return "forms-editors";
    }

    @GetMapping("/forms-elements.html")
    public String FormElements(){
        return "forms-elements";
    }

    @GetMapping("/forms-layouts.html")
    public String FormLayouts(){
        return "forms-layouts";
    }

    @GetMapping("/forms-validation.html")
    public String FormValidation(){
        return "forms-validation";
    }

    @GetMapping("/icons-bootstrap.html")
    public String IconsBootstrap(){
        return "icons-bootstrap";
    }

    @GetMapping("/icons-boxicons.html")
    public String IconsBoxicons(){
        return "icons-boxicons";
    }

    @GetMapping("/icons-remix.html")
    public String IconsRemix(){
        return "icons-remix";
    }

    @GetMapping("/pages-blank.html")
    public String PagesBlank(){
        return "pages-blank";
    }

    @GetMapping("/pages-contact.html")
    public String PagesContact(){
        return "pages-contact";
    }

    @GetMapping("/pages-error-404.html")
    public String Pages404(){
        return "pages-error-404";
    }

    @GetMapping("/pages-login.html")
    public String PagesLogin(){
        return "pages-login";
    }

    @GetMapping("/pages-register.html")
    public String PagesRegister(){
        return "pages-register";
    }

    @GetMapping("/tables-data.html")
    public String TablesData(){
        return "tables-data";
    }

    @GetMapping("/tables-general.html")
    public String TablesGeneral(){
        return "tables-general";
    }

    @GetMapping("/users-profile.html")
    public String UsersProfile(){
        return "users-profile";
    }
}
