#             Quo vadis java?
### Or news in newest LTS JDK25, as released 16/9/2025
###      With short walk from previous LTS
###        over 22, 23, 24 up to now.

See "slides" in [jdk25bjug.markdown](jdk25bjug.markdown) 
You can view them directly via [http://raw.githack.com](https://rawcdn.githack.com/judovana/jdk25bjug2025/f25c4c8860361c4b34b95d1aa16380ffa7c163bf/jdk25bjug.html)

By [judovana](https://github.com/judovana) (language/vm changes) , [andrlos](https://github.com/andrlos) (jfr/crypto) and [karm](https://github.com/karm) (AOT) from IBM's OpenJDK team.
Wednesday, 17th September 2025, JUG meetup in https://impacthub.cz/brno/

Most interesting are for sure the demos. Each JEP have one: https://github.com/judovana/jdk25bjug2025/tree/main/jdk25bjug-demos
### weakpoint format
Presentation written for https://github.com/tisnik/vim-weakpoint?tab=readme-ov-file#magic-command<br>
Dont forget to follow https://github.com/tisnik/vim-weakpoint?tab=readme-ov-file#installation steps

Warning, ~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua is slightly buggy, and you need to pass the in-tree filenames with full path:

```
lua  ~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua  jdk25bjug.markdown -deduct -height 30 -vim
jdk25bjug.markdown exists and is file
-clean: false
-deduct: true
-height: 30
-break: --PAGE--
-vim: true
lua: ~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua:65: bad argument #1 to 'match' (string expected, got nil)
stack traceback:
	[C]: in function 'string.match'
	~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua:65: in function 'deductFileName'
	~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua:165: in main chunk
	[C]: in ?
```
->
```
lua  ~/.vim/bundle/vim-weakpoint/WeekPointSplitter.lua  `pwd`/jdk25bjug.markdown -deduct -height 30 -vim
~/git/weak-point-presentations/jdk25bjug.markdown exists and is file
-clean: false
-deduct: true
-height: 30
-break: --PAGE--
-vim: true
-output: ~/git/weak-point-presentations/jdk25bjug-WeakPoint
Pages: 9
1.markdown
2.markdown
3.markdown
4.markdown
5.markdown
6.markdown
7.markdown
8.markdown
9.markdown
~/git/weak-point-presentations/jdk25bjug-WeakPoint
```

