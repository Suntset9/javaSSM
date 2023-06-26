<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 26/6/2023
  Time: 下午1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>世界读书日图书分享网站</title>
  <style>
    /* 定义全局样式 */
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
    }
    .container {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }
    h1, h2, h3 {
      margin-top: 0;
    }
    ul {
      list-style: none;
      margin: 0;
      padding: 0;
    }
    /* 定义活动页样式 */
    .activity {
      background-color: #f7f7f7;
      padding: 300px;
      text-align: center;
    }
    .activity h2 {
      font-size: 36px;
      margin-bottom: 20px;
    }
    .activity p {
      font-size: 24px;
      margin-bottom: 50px;
    }
    .activity audio {
      margin-top: 50px;
      width: 80%;
      max-width: 500px;
      display: block;
      margin: 0 auto;
    }
    /* 定义店铺主页样式 */
    .store {
      background-color: #fff;
      padding: 400px;
      text-align: center;
    }
    .store h2 {
      font-size: 36px;
      margin-bottom: 20px;
    }
    .store p {
      font-size: 24px;
      margin-bottom: 50px;
    }
    /* 定义商品页样式 */
    .product {
      background-color: #f7f7f7;
      padding: 50px;
      text-align: center;
    }
    .product h2 {
      font-size: 36px;
      margin-bottom: 20px;
    }
    .product p {
      font-size: 24px;
      margin-bottom: 50px;
    }
    .product ul {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      align-items: center;
    }
    .product li {
      width: 300px;
      margin: 20px;
      padding: 20px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
      text-align: center;
    }
    .product img {
      max-width: 80%;
      margin-bottom: 20px;
    }
    .product a {
      display: inline-block;
      padding: 10px 20px;
      background-color: #008CBA;
      color: #fff;
      text-decoration: none;
      margin-top: 20px;
      border-radius: 5px;
    }
    /* 定义广告弹窗样式 */
    .popup {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5);
      display: none;
      justify-content: center;
      align-items: center;
      z-index: 999;
    }
    .popup-content {
      background-color: #fff;
      padding: 50px;
      text-align: center;
      max-width: 100%;
      max-height: 100%;
      overflow: auto;
      border-radius: 5px;
    }
    .close-btn {
      position: absolute;
      top: 10px;
      right: 10px;
      font-size: 24px;
      color: #999;
      cursor: pointer;
    }
  </style>
</head>
<body>
<div class="container">
  <!-- 店铺主页 -->
  <div class="store">
    <h2>欢迎来到XXX图书店</h2>
    <p>我们提供最全面的图书资源，欢迎浏览我们的网站！</p>
    <a href="#products">查看我们的图书</a>
  </div>


  <!-- 商品页 -->
  <div class="product" id="products">
    <h2>热门图书推荐</h2>
    <ul>
      <li>
        <img src="imags/1.png" alt="book1">
        <h3>书籍名称</h3>
        <p>书籍描述</p>
        <a href="#1">立即购买</a>
        <a href="#">返回主页</a>
      </li>
      <li>
        <img src="imags/1.png" alt="book2">
        <h3>书籍名称</h3>
        <p>书籍描述</p>
        <a href="#1">立即购买</a>
        <a href="#">返回主页</a>
      </li>
      <li>
        <img src="imags/1.png" alt="book3">
        <h3>书籍名称</h3>
        <p>书籍描述</p>
        <a href="#1">立即购买</a>
        <a href="#">返回主页</a>
      </li>
    </ul>
  </div>

  <!-- 活动页 -->
  <div class="activity">
    <h2>世界读书日分享活动</h2>
    <p>欢迎参加我们的世界读书日分享活动，分享你最喜欢的书籍，赢取精美礼品！</p>
    <audio controls>
      <source src="audio/C400003j4qc34Wa6tK.m4a" type="audio/mpeg">
    </audio>


    <a href="#1">分享书籍</a>
  </div>

  <!-- 广告弹窗 -->
  <div class="popup">
    <div class="popup-content">
      <span class="close-btn">&times;</span>
      <h2>世界读书日分享活动</h2>
      <p>欢迎参加我们的世界读书日分享活动，分享你最喜欢的书籍，赢取精美礼品！</p>
      <form>
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">邮箱：</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="book">分享的书籍：</label>
        <input type="text" id="book" name="book" required><br><br>
        <input type="submit" value="提交">
      </form>
    </div>
  </div>
</div>
<!-- 引入jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    // 弹出广告弹窗
    $(".activity a").on("click", function() {
      $(".popup").fadeIn();
    });
    // 关闭广告弹窗
    $(".close-btn").on("click", function() {
      $(".popup").fadeOut();
    });
  });
</script>
</body>
</html>
