Hierarchical Index
==================

Class Hierarchy
---------------

This inheritance list is sorted roughly, but not completely,
alphabetically:

Main pagenum

ArrayList

MyList\< T \> pagenum

Class Index
===========

Class List
----------

Here are the classes, structs, unions and interfaces with brief
descriptions:

**Main** pagenum

**MyList\< T \>** pagenum

File Index
==========

File List
---------

Here is a list of all files with brief descriptions:

**C:/Users/radub/git/oql/OQL/src/Main.java** pagenum

**C:/Users/radub/git/oql/OQL/src/MyList.java** pagenum

Class Documentation
===================

Main Class Reference
--------------------

### Static Public Member Functions

static void **main** (String\[\] args)

### Member Function Documentation

#### static void Main.main (String\[\] *args*)\[static\]

6 {

7 // TODO Auto-generated method stub

8 List\<String\> elevi = new ArrayList\<String\>();

9
elevi.add(\"radu\");elevi.add(\"radu\");elevi.add(\"vasi\");elevi.add(\"vasi\");

10

11 List\<String\> materii = new ArrayList\<String\>();

12
materii.add(\"info\");materii.add(\"mate\");materii.add(\"chim\");materii.add(\"fiz\");

13

14 List\<Integer\> note = new ArrayList\<Integer\>();

15 note.add(10);note.add(9);note.add(7);note.add(8);

16

17 MyList catalog = new MyList();

18 catalog.add(elevi);catalog.add(materii);catalog.add(note);

19

20 /\* \|elev\|disc\|nota\|

21 \-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\--

22 \|radu\|info\| 10 \|

23 \-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\--

24 \|radu\|mate\| 9 \|

25 \-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\--

26 \|vasi\|chim\| 7 \|

27 \-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\--\*/

28

29 System.out.print(catalog.Select(\"0,2\").Where(\"vasi\").Group(1,
0));

30

31

32 }

References MyList\< T \>.Select().

#### The documentation for this class was generated from the following file:

C:/Users/radub/git/oql/OQL/src/**Main.java**

#### 

MyList\< T \> Class Template Reference
--------------------------------------

Inheritance diagram for MyList\< T \>:

### Public Member Functions

**MyList** ()

int\[\] **parseToInts** (String no)

**MyList**\< T \> **Select** (String cols)

### Package Functions

public\< T \> List\< Integer \> **findIf** (T t)

public\< T \> **MyList**\< T \> **Where** (T t)

public\< T \> **MyList**\< T \> **Group** (int col1, int col2)

public\< T \> double **Sum** (T t, int col)

### Static Package Attributes

static int\[\] **n**

*coloanele de afisat*

### Constructor & Destructor Documentation

#### MyList\< T \>.MyList ()

14 {

15 super();

16 // TODO Auto-generated constructor stub

17 }

### Member Function Documentation

#### public\<T\> List\<Integer\> MyList\< T \>.findIf (T *t*)\[package\]

> parcurgem toate sub-colectiile sa cautam cuv.

39 {

40 List\<Integer\> index=new ArrayList\<Integer\>(); //acolo unde vrem
sa pozitionam indexul

41 ///parcurgem toate sub-colectiile sa cautam cuv.

42 for(int i=0; i\<this.size() ;i++)

43 {

44 //System.out.println(this.get(i));

45 List\<T\> tmp = (List\<T\>) this.get(i);

46 Iterator\<T\> it = tmp.iterator();//pentru fiecare sub-lista

47 int p=0;

48 while(it.hasNext())

49 {

50 if (it.next().equals(t)){

51 index.add(p);

52 }

53 p++;

54 }

55 }

56

57 return index;

58 }

Referenced by MyList\< T \>.Sum(), and MyList\< T \>.Where().

#### public\<T\> MyList\<T\> MyList\< T \>.Group (int *col1*, int *col2*)\[package\]

76 {

77

78 MyList\<T\> arr=new MyList\<T\>();

79 List\<Double\> dbl = new ArrayList\<Double\>();

80 List\<T\> grp = (List\<T\>) this.get(col2);

81 Set\<T\> unique = new HashSet\<T\>(grp);

82 Iterator\<T\> it = unique.iterator();//pentru fiecare sub-lista

83

84 while(it.hasNext())

85 {

86 dbl.add(Sum(it.next(),col1));

87 }

88 arr.add((T) new ArrayList\<T\>(unique));//pt Having\...

89 arr.add((T) dbl);

90

91

92 return arr;

93

94 }

References MyList\< T \>.Sum().

#### int \[\] MyList\< T \>.parseToInts (String *no*)

19 {

20 String\[\] parts = no.split(\",\");

21 int\[\] n1 = new int\[parts.length\];

22 for(int n = 0; n \< parts.length; n++) {

23 n1\[n\] = Integer.parseInt(parts\[n\]);

24 }

25 return n1;

26 }

References MyList\< T \>.n.

Referenced by MyList\< T \>.Select().

#### MyList\<T\> MyList\< T \>.Select (String *cols*)

28 {

29 this.n = parseToInts(cols);

30

31 MyList\<T\> arr=new MyList\<T\>();

32 for(int i=0; i\<n.length;i++)

33 arr.add(this.get(n\[i\]));

34

35 return (MyList\<T\>) arr;

36 }

References MyList\< T \>.n, and MyList\< T \>.parseToInts().

Referenced by Main.main().

#### public\<T\> double MyList\< T \>.Sum (T *t*, int *col*)\[package\]

96 {

97 List\<T\> agr = (List\<T\>) this.get(col);

98 Iterator\<T\> it = agr.iterator();//pentru fiecare sub-lista

99 int p=0;

100 int sum=0;

101 while(it.hasNext())

102 {

103 T tp = it.next();

104 for(int i : findIf(t))

105 if (p==i)

106 sum+=Double.valueOf(tp.toString());

107 p++;

108

109 }

110 return sum;

111 }

References MyList\< T \>.findIf().

Referenced by MyList\< T \>.Group().

#### public\<T\> MyList\<T\> MyList\< T \>.Where (T *t*)\[package\]

> ce intoarce **Where()**
>
> parcurgem numai sub-colectiile(coloane) precizate in select ca sa
> adaugam elemente
>
> \<adauga din fiecare lista elementul de pe randul corespunzator

61 { ///ce intoarce Where()

62 MyList\<T\> myarr=new MyList\<T\>();

63 ///parcurgem numai sub-colectiile(coloane) precizate in select ca sa
adaugam elemente

64 for(int i=0; i\<this.size();i++)

65 {

66 List\<T\> tmp = (List\<T\>) this.get(i);

67 List\<T\> arr = new ArrayList\<T\>();

68 for (Integer id : findIf(t))

69 arr.add(tmp.get(id));///\<adauga din fiecare lista elementul de pe
randul corespunzator

70 myarr.add((T) arr);

71 }

72 return myarr;

73 }

References MyList\< T \>.findIf().

### Member Data Documentation

#### int \[\] MyList\< T \>.n\[static\], \[package\]

coloanele de afisat

Referenced by MyList\< T \>.parseToInts(), and MyList\< T \>.Select().

#### The documentation for this class was generated from the following file:

C:/Users/radub/git/oql/OQL/src/**MyList.java**

File Documentation
==================

C:/Users/radub/git/oql/OQL/doc/MyList.md File Reference
-------------------------------------------------------

C:/Users/radub/git/oql/OQL/src/Main.java File Reference
-------------------------------------------------------

### Classes

class **Main**

C:/Users/radub/git/oql/OQL/src/MyList.java File Reference
---------------------------------------------------------

### Classes

class **MyList\< T \>**

Index
=====

INDEX
