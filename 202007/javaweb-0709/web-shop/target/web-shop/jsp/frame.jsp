<%@ page import="com.frans.service.goods.GoodsServiceImpl" %>
<%@ page import="com.frans.pojo.Goods" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    GoodsServiceImpl goodsService = new GoodsServiceImpl();
    List<Goods> lst = goodsService.getGoodsList();
%>
<table border="1" width="98%">
    <%  for ( int i=0;i<lst.size();i++ ){ %>
    <tr>
        <td width="20%" >Pic(get)</td>

        <td width="150" align="center">
            <!-- goodsImgUrl=img/DVD/807200002.jpg -->
            <img alt="图片" width="120" src="${pageContext.request.contextPath }/<%= lst.get(i).getGoodsImgUrl()  %>">
        </td>

        <td>
            <table>
                <tr> <td>商品ID：<%= lst.get(i).getGoodsId() %></td></tr>
                <tr> <td>商品Type：<%= lst.get(i).getGoodsType() %></td></tr>
                <tr> <td>商品Price：<%= lst.get(i).getGoodsPrice() %></td></tr>
                <tr> <td>商品数量：<%= lst.get(i).getGoodsAmount() %></td></tr>
                <tr> <td>商品名称：<%= lst.get(i).getGoodsName() %></td></tr>
                <tr> <td>
                    <a href="buygoods?goodsId=<%= lst.get(i).getGoodsId() %>">商品购买</a>
                </td></tr>
            </table>
        </td>
    </tr>
    <%  }  									%>

    </tr> -->

</table>

</body>
</html>
</body>
</html>
