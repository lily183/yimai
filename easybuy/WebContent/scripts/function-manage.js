// JavaScript Document
function DeleteProduct(id)
{
	if(confirm("是否删除？")) {
		location.href = "ProductDeleteServlet?pid=" + id;
	}
}
function DeleteCategory(id)
{
	if(confirm("是否删除？")) {
		location.href = "CatDeleteServlet?cid=" + id;
	}
}
//删除新闻
function Deletenews(id)
{
	if(confirm("您确认要删除此条新闻")) {
		location.href = "newsdeleteServlet?id=" + id;
	}
}

//删除留言
function Deletecomment(id)
{
	if(confirm("您确认要删除此条留言吗？")) {
		location.href = "comdeleteServlet?id=" + id;
	}
}