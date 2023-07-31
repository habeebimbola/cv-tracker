//package cvtrackertask.info.guesword.domain;
//
//public class List {
//    private ListNode firstNode;
//    private ListNode lastNode;
//
//    public List() {
//        firstNode = lastNode = null;
//    }
//
//    public void insertAtFront(Object data)
//    {
//        if(isEmpty())
//        {
//            firstNode = lastNode = new ListNode(data);
//        }
//        else
//        {
//            firstNode = new ListNode(data, firstNode);
//        }
//    }
//
//    public void insertAtBack(Object data){
//        if(isEmpty())
//        {
//            firstNode = lastNode = new ListNode(data,firstNode);
//        }
//        else
//        {
//            lastNode = lastNode.nextNode = new ListNode(data);
//        }
//
//    }
//
//    public Object removeFromFront()
//    {
//        if(isEmpty())
//        {
//            throw new RuntimeException("Empty List. Cannot Remove From An Empty");
//        }
//        Object removedItem = firstNode.data;
//
//        if(firstNode == lastNode)
//        {
//            firstNode = lastNode = null;
//        }
//        else
//        {
//            firstNode = firstNode.nextNode;
//        }
//        return removedItem;
//    }
//
//    public Object removeFromBack()
//    {
//        return null;
//    }
//    private boolean isEmpty()
//    {
//        return (firstNode == null );
//    }
//}
