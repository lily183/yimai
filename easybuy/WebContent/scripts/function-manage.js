// JavaScript Document
function DeleteProduct(id)
{
	if(confirm("�Ƿ�ɾ����")) {
		location.href = "ProductDeleteServlet?pid=" + id;
	}
}
function DeleteCategory(id)
{
	if(confirm("�Ƿ�ɾ����")) {
		location.href = "CatDeleteServlet?cid=" + id;
	}
}
//ɾ������
function Deletenews(id)
{
	if(confirm("��ȷ��Ҫɾ����������")) {
		location.href = "newsdeleteServlet?id=" + id;
	}
}

//ɾ������
function Deletecomment(id)
{
	if(confirm("��ȷ��Ҫɾ������������")) {
		location.href = "comdeleteServlet?id=" + id;
	}
}