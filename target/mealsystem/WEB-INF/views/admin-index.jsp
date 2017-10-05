<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>后台管理系统首页 - cssmoban</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/assets/css/admin.css">
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>Amaze</strong> <small>后台管理</small>
  </div>

  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span class="am-badge am-badge-warning">5</span></a></li>
      <li class="am-dropdown" data-am-dropdown>
        <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
          <span class="am-icon-users"></span> 管理员 <span class="am-icon-caret-down"></span>
        </a>
        <ul class="am-dropdown-content">
          <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
          <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
          <li><a href="/form/user/signout"><span class="am-icon-power-off"></span> 退出</a></li>
        </ul>
      </li>
      <li><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main">
  <!-- sidebar start -->
  <div class="admin-sidebar">
    <ul class="am-list admin-sidebar-list">
      <li><a href="/form/user/login"><span class="am-icon-home"></span> 首页</a></li>
      <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span> 页面 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
          <li><a href="/form/meal/add" class="am-cf"><span class="am-icon-check"></span> 添加饭卡 <span class="am-icon-star am-fr am-margin-right admin-icon-yellow"></span></a></li>
        </ul>
      </li>
      <li><a href="/form/meal/show"><span class="am-icon-table"></span> 用户</a></li>
      <li><a href="/form/user/signout"><span class="am-icon-sign-out"></span> 注销</a></li>
    </ul>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-bookmark"></span> 公告</p>
        <p>时光静好，与君语；细水流年，与君同。</p>
      </div>
    </div>

    <div class="am-panel am-panel-default admin-sidebar-panel">
      <div class="am-panel-bd">
        <p><span class="am-icon-tag"></span> meal</p>
        <p>Welcome to the Meal!</p>
      </div>
    </div>
  </div>
  <!-- sidebar end -->

  <!-- content start -->
  <div class="admin-content">

    <div class="am-cf am-padding">
      <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">首页</strong> / <small>一些常用模块</small></div>
    </div>
<c:if test="${ ! empty consumption}">
  <ul class="am-avg-sm-1 am-avg-md-4 am-margin am-padding am-text-center admin-content-list ">
    <li><a href="#" class="am-text-success"><span class="am-icon-btn am-icon-file-text"></span><br/>记录<br/>${consumption.record}条</a></li>
    <li><a href="#" class="am-text-warning"><span class="am-icon-btn am-icon-briefcase"></span><br/>消费金额<br/>${consumption.ever_Consumption}￥</a></li>
    <li><a href="#" class="am-text-danger"><span class="am-icon-btn am-icon-recycle"></span><br/>今日金额<br/>${consumption.today_Consumption}￥</a></li>
    <li><a href="#" class="am-text-secondary"><span class="am-icon-btn am-icon-user-md"></span><br/>用户<br/>${consumption.mealQuantity}人</a></li>
  </ul>

    <div class="am-g">
      <div class="am-u-sm-12">
        <table class="am-table am-table-bd am-table-striped admin-content-table">
          <thead>
          <tr>
            <th>ID</th><th>消费金额（￥）</th><th>地点</th><th>时间</th><th>管理</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${consumption.recordRow}" var="strip">
            <tr><td>${strip.record_id}</td><td>${strip.consume}</td><td>${strip.countent}</td> <td><span class="am-badge am-badge-secondary">${strip.consume_datetime}</span></td>
              <td>
                <div class="am-dropdown" data-am-dropdown>
                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
                  <ul class="am-dropdown-content">
                    <li><a href="#">1. 编辑</a></li>
                    <li><a href="/form/record/delete/${strip.record_id}">2. 删除</a></li>
                  </ul>
                </div>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
        <ul class="am-pagination am-fr admin-content-pagination">
          <li class="am-disabled"><a href="#">&laquo;</a></li>
          <li class="am-active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">&raquo;</a></li>
        </ul>
      </div>
    </div>

    <div class="am-panel am-panel-default">
      <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">消费统计<span class="am-icon-chevron-down am-fr" ></span></div>
      <div id="collapse-panel-2" class="am-in">
        <table class="am-table am-table-bd am-table-bdrs am-table-striped am-table-hover">
          <tbody>
          <tr>
            <th class="am-text-center">#</th>
            <th>地点</th>
            <th>消费（￥）</th>
          </tr>
          <c:forEach items="${contents}" var="content">
            <tr>
              <td class="am-text-center"><img src="assets/i/examples/admin-chrome.png" alt=""></td>
              <td>${content.key}</td>
              <td>${content.value}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <ul class="am-pagination am-fr admin-content-pagination">
        <li class="am-disabled"><a href="#">&laquo;</a></li>
        <li class="am-active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
      </ul>
    </div>

</c:if>
  <!-- content end -->

</div>

<footer>
  <hr>
  <p class="am-padding-left">© 2018 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="/assets/js/polyfill/rem.min.js"></script>
<script src="/assets/js/polyfill/respond.min.js"></script>
<script src="/assets/js/amazeui.legacy.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/amazeui.min.js"></script>
<!--<![endif]-->
<script src="/assets/js/app.js"></script>
</body>
</html>
