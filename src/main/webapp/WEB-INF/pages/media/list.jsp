<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/js/jqueryHover/demo.css">
<div class="container">
    <div class="row">
        <div id="content" class="col-lg-12">
            <!-- PAGE HEADER-->
            <%@include file="../common/common-breadcrumb.jsp" %>
            <div class="row">
                <div class="col-md-12">
                    <!-- BOX -->
                    <div class="box border blue">
                        <div class="box-title">
                            <h4><i class="fa fa-table"></i>多媒体信息</h4>
                        </div>
                        <%@include file="../common/common-menubar.jsp" %>
                        <div class="box-body">
                            <div id="contentDiv">
                                <div class="box-body">
                                    <div class="wrapper">
                                        <ul>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic1.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture1
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic2.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture2
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic3.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture3
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic4.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture4
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic2-1.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture5
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic2-2.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture6
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic2-3.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture7
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic2-4.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture8
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic3-1.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture9
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic3-2.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture10
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic3-3.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture11
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class='picBox'>
                                                    <div class='show'>
                                                        <image height='180px' width='180px' src='/js/jqueryHover/img/pic3-4.png'></image>
                                                    </div>
                                                    <div class='hide'>
                                                        <h3>
                                                            Picture12
                                                        </h3>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /BOX -->
                </div>
            </div>
            <%@include file="../common/common-back2top.jsp" %>
        </div>
        <!-- /CONTENT-->
    </div>
</div>

<script src="/js/jquery/jquery-2.0.3.min.js"></script>
<script src="/js/jqueryHover/demo.js"></script>
<script type="text/javascript" src="/js/app/media/media.js"></script>
