package base.reg;

public class Test {


  //了解这些元字符的含义
    //  .	匹配除换行符以外的任意字符
    //  \w	匹配字母或数字或下划线
    //  \s	匹配任意的空白符
    //  \d	匹配数字
    //  \b	匹配单词的开始或结束
    //  ^  	匹配字符串的开始 从输入字符串的开头开始匹配
    //  $	匹配字符串的结束 从输入字符串的结尾结束匹配


    // *    匹配重复任意次(可能是0次)
    // +    匹配重复1次或更多次


    // 因为使用了^和$，所以输入的整个字符串都要用来和\d{5,12}来匹配  {5} 表示重复五次， {5,12}表示重复5到12次 \d表示数字， 即^\d{5,12}$ 是陪陪一个5到12位的数字


    // 如果要匹配 * \  这种元字符  这需要转义  比如 \.和\*


    // 表示重复的写法
    // *	   重复零次或更多次
    // +	   重复一次或更多次
    // ?	   重复零次或一次
    // {n}	   重复n次
    // {n,}	   重复n次或更多次
    // {n,m}   重复n到m次

    //  [] 用来指定一个集合  里面的类似于枚举  例如[0-9]代表的含意与\d就是完全一致的  同理[a-z0-9A-Z_]也完全等同于\w
    
    //  \(?0\d{2}[) -]?\d{8}  表示 首先是一个转义字符\(,它能出现0次或1次(?),然后是一个0，后面跟着2个数字(\d{2})，然后是)或-或空格中的一个，它出现1次或不出现(?)，最后是8个数字(\d{8})


    // 分支条件  |

    // 反义
    //  \W	      匹配任意不是字母，数字，下划线，汉字的字符
    //  \S	      匹配任意不是空白符的字符
    //  \D	      匹配任意非数字的字符
    //  \B	      匹配不是单词开头或结束的位置
    //  [^x]	  匹配除了x以外的任意字符
    //  [^aeiou]  匹配除了aeiou这几个字母以外的任意字符

    // 懒惰限定符
    //  *?	    重复任意次，但尽可能少重复
    //  +?	    重复1次或更多次，但尽可能少重复
    //  ??	    重复0次或1次，但尽可能少重复
    //  {n,m}?	重复n到m次，但尽可能少重复
    //  {n,}?	重复n次以上，但尽可能少重复



    
}
