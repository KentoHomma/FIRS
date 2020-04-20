<%@ page pageEncoding="utf-8"%>

<jsp:include page="Header.jsp" />


<div class="top-wrapper">
<form method="post" action="loginAction">
    <table style="text-align: center;">
            <tr>
                <th class="header">メールアドレス</th>
                <td style="width: 250px;">
                    <input type="text" placeholder="メールアドレス" name="mail" required="required"
                        style="width: 100%;" value="${mail }"/>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">パスワード</th>
                <td>
                    <input type="password" placeholder="パスワード" name="pass" required="required"
                        style="width: 100%;" value="${pass }" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="btnArea">
                    <input type="submit" value="ログイン"  />
                </td>
            </tr>
        </table>
        </form>
      </div>

<jsp:include page="Footer.jsp" />
