    function visao() {
        visao_display.style.display = "none";
        missao_display.style.display = "block";

        mudar.style.left = "0";
    }

    function misao() {
        visao_display.style.display = "block";
        missao_display.style.display = "none";
        mudar.style.left = "50%";
    }
    let teste = 0;
    function fn_muda_tema(){
        
        if(teste == 0){
            document.getElementById('estilo_site').setAttribute('href', './CSS/Estilo_Site_claro.css');
            document.getElementById('estilo_menu').setAttribute('href', './CSS/Estilo_menu_claro.css');
            teste++;
        }else{
            document.getElementById('estilo_site').setAttribute('href', './CSS/Estilo_Site_escuro.css');
            document.getElementById('estilo_menu').setAttribute('href', './CSS/Estilo_menu_escuro.css');
            teste--;
        }

    }
     function fn_home(){
            opt_home.classList.remove('aqui01');
            txt_home.classList.remove('active');
            opt_about.classList.remove('aqui01');
            txt_about.classList.remove('active');
            opt_service.classList.remove('aqui01');
            txt_service.classList.remove('active');
            opt_home.classList.add('aqui01');
            txt_home.classList.add('active');
    }
    function fn_about(){
            opt_home.classList.remove('aqui01');
            txt_home.classList.remove('active');
            opt_about.classList.remove('aqui01');
            txt_about.classList.remove('active');
            opt_service.classList.remove('aqui01');
            txt_service.classList.remove('active');
            opt_about.classList.add('aqui01');
            txt_about.classList.add('active');
        
    }
    function fn_service(){
            opt_home.classList.remove('aqui01');
            txt_home.classList.remove('active');
            opt_about.classList.remove('aqui01');
            txt_about.classList.remove('active');
            opt_service.classList.remove('aqui01');
            txt_service.classList.remove('active');
            opt_service.classList.add('aqui01');
            txt_service.classList.add('active');
    }
