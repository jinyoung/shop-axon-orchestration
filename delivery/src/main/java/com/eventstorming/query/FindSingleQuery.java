<!DOCTYPE html>
<html lang="en">
<head>
    <base href="/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="title" content="EventStorming2Code">
    <meta name="description" content="EventStorming to Code Generator">
    <meta name="image" content="https://user-images.githubusercontent.com/54785805/120609107-dbfa1f80-c48c-11eb-8928-2bba293d464e.png">
    <meta name="description" content="비대면 MSAEZ 교육 도구">
    <meta name="keywords"
          content="eventstorming, eventstorming2code, msa, micro service architecture,  microservicearchitecture">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <!--[if IE]><link rel="icon" href="favicon.ico"><![endif]-->
    <title>MSA Easy</title>
    <link rel="stylesheet"
          href="/github-markdown.css">
    <link rel="stylesheet"
            href="/global-style.css">

    <!-- $ 관련-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/lodash@4.17.11/lodash.min.js"></script>
    <script type="javascript" src="static/lib/jqueryXML2JSON/jquery.xml2json.js"></script>
    <script type="javascript" src="static/slimscroll/jquery.slimscroll.min.js"></script>
    <!--    google-->
    <script src="https://apis.google.com/js/client.js"></script>
    <script src="https://apis.google.com/js/api.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    
    <!--  firebase  -->
    <!-- Firebase App (the core Firebase SDK) is always required and must be listed first -->
    <script src="https://www.gstatic.com/firebasejs/6.2.0/firebase-app.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
    <!-- iamport.payment.js -->
    <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

    <!-- Add Firebase products that you want to use -->
    <script src="https://www.gstatic.com/firebasejs/firebase/6.2.0/firebase-auth.js"></script>
    <script src="https://www.gstatic.com/firebasejs/firebase/6.2.0/firebase-firestore.js"></script>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-153107610-1"></script>
    <!--i18n-->
    <script src="https://unpkg.com/vue-i18n/dist/vue-i18n.js"></script>
    <script src="https://unpkg.com/vue-i18n@8"></script>
    <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/3.0.1/mustache.min.js"></script>-->
    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <!--<script src="static/iam-client/iam-api-2.0.1.js"></script>-->
    <!-- <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="//unpkg.com/vue-material@0.7.4/dist/vue-material.css"> -->
    <link rel="stylesheet" href="static/external/font-awesome.min.css">
    <link rel="stylesheet" href="static/external/fonts.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Material+Icons">
    <link href="static/bpmn/css/bpmn.css" rel="stylesheet" type="text/css">
    <!-- jquery-ui, jquery.contextmenu -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="/static/lib/jquery-contextMenu/jquery.contextMenu.css"/>
    <script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
    <link rel="stylesheet"
          href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/styles/idea.min.css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.18.1/highlight.min.js"></script>
    <link rel="stylesheet"
          href="static/github-markdown.css">
    <!-- Is Not Template -->



    <!-- ============= LT Script ============= -->
    <script defer type="text/javascript" src="https://cdn.jsdelivr.net/npm/acebase-client@latest/dist/browser.min.js"></script>
    <script defer type="text/javascript" src="static/lib/jquery-contextMenu/jquery.contextMenu.js"></script>
    <!-- html 아이콘 관련 라이브러리 https://fontawesome.com/v5.15/icons?d=gallery&p=2 사이트 접속 후 i tag 복사 후 사용 -->
    <script defer src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
    <script defer type="text/javascript" src="static/lib/opengraph/OpenGraph-0.1.3-SNAPSHOT.js"></script>
    <!-- ============= End of LT Script ====== -->

    <!-- libs -->
    <!-- TODO: please change local version -->
    <!-- <script src="https://unpkg.com/hybind@latest/index.js"></script> -->

    <script type="text/javascript" src="static/external/marked.min.js"></script>
    <script type="text/javascript" src="static/external/ansi_up.min.js"></script>
    <script type="text/javascript" src="static/external/prism.js"></script>
    <script type="text/javascript" src="static/external/katex.min.js"></script>
    <script type="text/javascript" src="static/external/katex-auto-render.min.js"></script>
    <script type="text/javascript" src="static/external/notebook.min.js"></script>

    <script>
        var profile = 'local';
        var config = {};

        /**
         * Get profile from system env given by dcos
         */
        //gtag
        window.dataLayer = window.dataLayer || [];
        function gtag() {
            dataLayer.push(arguments);
        }
        gtag('js', new Date());
        gtag('config', 'UA-153107610-1');
        gtag('config', window.location.path);

        // $.ajax({
        //     url: "../static/env.txt",
        //     type: "get",
        //     async: false,
        //     success: function (data) {
        //         var lines = data.split('\n');
        //         $.each(lines, function (i, line) {
        //             if (line && line.indexOf('VUE_APP_API_HOST=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.API_HOST = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_DB_HOST=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.DB_HOST = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_DB_PORT=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.DB_PORT = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_DB_NAME=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.DB_NAME = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_CLUSTER_ADDRESS=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.CLUSTER_ADDRESS = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_PROXY_SERVER=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.PROXY_SERVER = value;
        //             }
        //             if (line && line.indexOf('VUE_APP_MODE=') == 0) {
        //                 let value = line.split('=')[1];
        //                 window.MODE = value;
        //                 // if(value == "onprem") {
        //                 //     $('head').append('https://cdn.jsdelivr.net/npm/acebase-client@latest/dist/browser.min.js');
        //                 // }
        //             }
        //         });
        //     },
        //     error: function (e) {
        //         console.log('Failed to get env',e);
        //     }
        // });
    </script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Material+Icons">
    <link rel="stylesheet" href="//cdn.materialdesignicons.com/5.0.45/css/materialdesignicons.min.css">
<link href="/0.js" rel="prefetch"><link href="/1.js" rel="prefetch"><link href="/10.js" rel="prefetch"><link href="/11.js" rel="prefetch"><link href="/12.js" rel="prefetch"><link href="/13.js" rel="prefetch"><link href="/14.js" rel="prefetch"><link href="/15.js" rel="prefetch"><link href="/16.js" rel="prefetch"><link href="/17.js" rel="prefetch"><link href="/18.js" rel="prefetch"><link href="/19.js" rel="prefetch"><link href="/2.js" rel="prefetch"><link href="/20.js" rel="prefetch"><link href="/21.js" rel="prefetch"><link href="/22.js" rel="prefetch"><link href="/23.js" rel="prefetch"><link href="/24.js" rel="prefetch"><link href="/25.js" rel="prefetch"><link href="/26.js" rel="prefetch"><link href="/27.js" rel="prefetch"><link href="/28.js" rel="prefetch"><link href="/29.js" rel="prefetch"><link href="/3.js" rel="prefetch"><link href="/30.js" rel="prefetch"><link href="/31.js" rel="prefetch"><link href="/32.js" rel="prefetch"><link href="/33.js" rel="prefetch"><link href="/34.js" rel="prefetch"><link href="/35.js" rel="prefetch"><link href="/36.js" rel="prefetch"><link href="/37.js" rel="prefetch"><link href="/38.js" rel="prefetch"><link href="/39.js" rel="prefetch"><link href="/4.js" rel="prefetch"><link href="/40.js" rel="prefetch"><link href="/41.js" rel="prefetch"><link href="/42.js" rel="prefetch"><link href="/43.js" rel="prefetch"><link href="/44.js" rel="prefetch"><link href="/45.js" rel="prefetch"><link href="/46.js" rel="prefetch"><link href="/47.js" rel="prefetch"><link href="/48.js" rel="prefetch"><link href="/49.js" rel="prefetch"><link href="/5.js" rel="prefetch"><link href="/50.js" rel="prefetch"><link href="/51.js" rel="prefetch"><link href="/52.js" rel="prefetch"><link href="/53.js" rel="prefetch"><link href="/54.js" rel="prefetch"><link href="/55.js" rel="prefetch"><link href="/56.js" rel="prefetch"><link href="/57.js" rel="prefetch"><link href="/58.js" rel="prefetch"><link href="/59.js" rel="prefetch"><link href="/6.js" rel="prefetch"><link href="/60.js" rel="prefetch"><link href="/61.js" rel="prefetch"><link href="/62.js" rel="prefetch"><link href="/63.js" rel="prefetch"><link href="/64.js" rel="prefetch"><link href="/7.js" rel="prefetch"><link href="/8.js" rel="prefetch"><link href="/9.js" rel="prefetch"><link href="/BigEventStorming.js" rel="prefetch"><link href="/BigEventStorming~BpmnModelCanvas~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~Kubernetes~8713f7ca.js" rel="prefetch"><link href="/BigEventStorming~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~KubernetesModelCanvas~LabL~6a2e30e1.js" rel="prefetch"><link href="/BigEventStorming~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~LabLocator.js" rel="prefetch"><link href="/BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~IdeLoadingPage~LabLocator~StickyModelCanvas.js" rel="prefetch"><link href="/BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~LabLocator~ReplayPortal.js" rel="prefetch"><link href="/BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~LabLocator~StickyModelCanvas.js" rel="prefetch"><link href="/BpmnModelCanvas.js" rel="prefetch"><link href="/BusinessModelCanvas.js" rel="prefetch"><link href="/ClassModeler.js" rel="prefetch"><link href="/ClassRoom.js" rel="prefetch"><link href="/ClassRoom~ClassRounge~LabLocator.js" rel="prefetch"><link href="/ClassRounge.js" rel="prefetch"><link href="/EventModeler.js" rel="prefetch"><link href="/EventStorming.14f79f359123ad31bb5d.hot-update.js" rel="prefetch"><link href="/EventStorming.js" rel="prefetch"><link href="/IdeLoadingPage.js" rel="prefetch"><link href="/KubernetesModelCanvas.js" rel="prefetch"><link href="/LabLocator.js" rel="prefetch"><link href="/LabPortal.js" rel="prefetch"><link href="/LoginPage.js" rel="prefetch"><link href="/ManagePurchaseItemListPage.js" rel="prefetch"><link href="/MyPageManager.js" rel="prefetch"><link href="/PersonalInfo.js" rel="prefetch"><link href="/ProcessDesigner.js" rel="prefetch"><link href="/Provision.js" rel="prefetch"><link href="/ReplayPortal.js" rel="prefetch"><link href="/SignInHelper.js" rel="prefetch"><link href="/StickyModelCanvas.js" rel="prefetch"><link href="/labAdminTest.js" rel="prefetch"><link href="/labMonitoring.js" rel="prefetch"><link href="/startelectron.js" rel="prefetch"><link href="/vendors~BigEventStorming~BpmnModelCanvas~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~Ku~6d8083cc.js" rel="prefetch"><link href="/vendors~BigEventStorming~BpmnModelCanvas~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~Ku~9d317ef8.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassModeler~ClassRoom~ClassRounge~EventStorming~LabLoc~1f63833f.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~KubernetesModelCan~040c37f4.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassModeler~ClassRoom~EventStorming~LabLocator.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~KubernetesModelCanvas~LabLocator.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~LabLocator.js" rel="prefetch"><link href="/vendors~BigEventStorming~BusinessModelCanvas~ClassRoom~EventStorming~LabLocator~StickyModelCanvas.js" rel="prefetch"><link href="/vendors~ClassRoom~LabLocator.js" rel="prefetch"><link href="/vendors~LabLocator.js" rel="prefetch"><link href="/app.js" rel="preload" as="script"><link href="/vendors~app.js" rel="preload" as="script"><link rel="icon" type="image/png" sizes="32x32" href="/img/icons/favicon-32x32.png"><link rel="icon" type="image/png" sizes="16x16" href="/img/icons/favicon-16x16.png"><link rel="manifest" href="/manifest.json"><meta name="theme-color" content="#4DBA87"><meta name="apple-mobile-web-app-capable" content="no"><meta name="apple-mobile-web-app-status-bar-style" content="default"><meta name="apple-mobile-web-app-title" content="service-ui"><link rel="apple-touch-icon" href="/img/icons/apple-touch-icon-152x152.png"><link rel="mask-icon" href="/img/icons/safari-pinned-tab.svg" color="#4DBA87"><meta name="msapplication-TileImage" content="/img/icons/msapplication-icon-144x144.png"><meta name="msapplication-TileColor" content="#000000"></head>
<body>
<script>

    // window.GitpleConfig = {appCode: '0XY0AvdJ820MDsNwIZuJIgQqdn1kc3'};
    // !function () {
    //     function e() {
    //         function e() {
    //             var e = t.contentDocument, a = e.createElement("script");
    //             a.type = "text/javascript", a.async = !0, a.src = window[n] && window[n].url ? window[n].url + "/inapp-web/gitple-loader.js" : "https://app.gitple.io/inapp-web/gitple-loader.js", a.charset = "UTF-8", e.head && e.head.appendChild(a)
    //         }
    //
    //         var t = document.getElementById(a);
    //         t || ((t = document.createElement("iframe")).id = a, t.style.display = "none", t.style.width = "0", t.style.height = "0", t.addEventListener ? t.addEventListener("load", e, !1) : t.attachEvent ? t.attachEvent("onload", e) : t.onload = e, document.body.appendChild(t))
    //     }
    //
    //     var t = window, n = "GitpleConfig", a = "gitple-loader-frame";
    //     if (!window.Gitple) {
    //         document;
    //         var i = function () {
    //             i.ex && i.ex(arguments)
    //         };
    //         i.q = [], i.ex = function (e) {
    //             i.processApi ? i.processApi.apply(void 0, e) : i.q && i.q.push(e)
    //         }, window.Gitple = i, t.attachEvent ? t.attachEvent("onload", e) : t.addEventListener("load", e, !1)
    //     }
    // }();
    // console.log("init")
    // Gitple('boot');

</script>
<noscript>

    <strong>We're sorry but service-ui doesn't work properly without JavaScript enabled. Please enable it to
        continue.</strong>
</noscript>
<div id="app"></div>
<!-- built files will be auto injected -->
<script type="text/javascript" src="/vendors~app.js"></script><script type="text/javascript" src="/app.js"></script></body>
</html>
