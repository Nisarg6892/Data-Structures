boolean deleteNode(Node node){
	if(node == null || node.next == null){
		return false;
	}
	node.data = node.next.data;
	node.next = node.next.next;
	return true;
}
