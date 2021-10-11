package realize.stringmatch;

/**
 * 如何实现搜索引擎的搜索关键词提示功能
 *
 * Trie树的本质是利用字符串之间的公共前缀，将重复的前缀合并在一起.
 * 用途：前缀匹配的场景中. 其他数据结构无法代替
 *       各种搜索引擎，输入法自动补全、浏览器网址自动补全等功能.
 *
 * Created by dell on 2021/10/7.
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char [] text){
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if(p.chidren[index] == null){
                TrieNode trieNode = new TrieNode(text[i]);
                p.chidren[index] = trieNode;
            }
            p = p.chidren[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char [] pattern){
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if(p.chidren[index] == null ){
                return false;
            }
            p = p.chidren[index];
        }
        if(p.isEndingChar == false) return false;  // 不能完全匹配.
        else return true;
    }

    public class TrieNode{
        public char data;
        public TrieNode[] chidren = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
        }
    }






}
