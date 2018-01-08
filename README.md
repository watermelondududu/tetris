# 提示：
若要修改成自己的DesignView，
請修改以下兩組宣告：
1. tetris > TetrisStartGame.java > main > DesignView game = new 你的學號_DesignView();
2. view > ShowView.java > drawSquare > DesignView tmp = new 你的學號_DesignView();

## Controller
TetrisBoard  
boardWidth  
boardHeigh  
isFallingFinished  
isStarted  
isPaused  
numLinesRemoved  
currentX  
currentY  
timer  
currentPiece  
map//原board

* gameAction//計時器驅動，要麼tetris往下落一行，要麼是下落完了，那就生成新的方塊
* isStarted / isPaused
* unshaped//原isCurrentPieceNoShaped//判斷該點有沒有被占用
* start//遊戲開始，清除畫布，產生一個新方塊，打開計時器
* pause
* straightDown//下落到底
* getSquareShape//原shapeAt//返回x，y處的map【index】（即返回當前坐標處被什麼形狀的俄羅斯方塊佔據了）
* newPiece//如果新產生的piece時就不能移動，那麼遊戲結束
* move//調用updateMap更新地圖；調用repaint重畫
* reachBottom//原pieceDropped //到底之後調用dellLine
* dellLine//原removeFullLines//從下往上全部循環，滿行則該行等於上一行的情況，以此實現消行
* moveLeft / moveRight
* rotateLeft / rotateRight //先調用getLeftRotatedPiece，再判斷是否合法，再下落或返回 




## Model
Tetrominoes{NoShape,I,L,J,O,Z,S,T}  
pieceShape  
coords[][]  
coordsTable[][]

* shape
    * setPieceShape
* setPieceShape
    * System.arraycopy
* setX//設置某個小方塊的x坐標
* setY
* getx//取得四個小方塊中某個小方塊的x坐標
* gety
* getPieceShape
* RandomShape
* minX//獲取四個小方塊中最小的X坐標
* minY//獲取四個小方塊中最小的Y坐標
* getLeftRotatedPiece//得到左旋後的piece
* getRightRotatedPiece
* valid//判斷邊界和觸底
* updateMap//更新地圖
* clearMap//把每個坐標都置為noshape//原clearBoard



## View
JLabel statusBar  
TetrisBoard board  

* init
* getStatusBar
* paint
* squareWidth
* squareHeight
* drawSquare

## DesignView
宣告模板的interface


## TetrisBoard  
BOARD_WIDTH  
BOARD_HEIGHT  
Controller controller

* TetrisBoard
* actionPerformed
* Klistner
    * getKeyCode
    * p: pause;isPaused
    * 相應操作
    

## TetrisStartGame
TetrisStartGame

* main //進入點
