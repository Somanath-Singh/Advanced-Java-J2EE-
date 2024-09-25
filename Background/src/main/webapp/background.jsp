<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- background 1 -->
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> -->
<!-- <!-- background jquery --> -->
<!--  <script src="./Background-polygonizr/src/polygonizr.min.js"></script> -->
  
<!--   <style> -->
/*   		body{ */
/*                   background-color: black; */
/*         } */
<!--   </style> -->

        <!-- background 2 -->
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="./background-particle-daisy/daisy.js" defer></script>

    <style>
        body{
            background-color: black;
        }
        #background{
            height: 100vh;
            overflow: hidden;
            filter: brightness(500%);
        }
    </style>
</head>
<body>
   <!-- background 1 -->
<!-- 	<div id="background_change"></div> -->
	
<!-- <!-- 	<script> --> -->
<!-- //         $('#background_change').polygonizr({ -->

<!-- //                 // Indicates the time (in seconds) to pause after a node has reached its destination.  -->
<!-- //                 restNodeMovements: 1, -->

<!-- //                 // Indicates how long (in seconds) it will take for a node to move from start to finish.  -->
<!-- //                 duration: 3, -->

<!-- //                 // Indicates the maximum (will be randomized) distance a node can move (in pixles) from its starting position.  -->
<!-- //                 nodeMovementDistance: 100, -->

<!-- //                 // Indicates the maximum (will be randomized) distance a node can have in depth (for a better <a href="https://www.jqueryscript.net/tags.php?/3D/">3D</a> effect). Default: 300 -->
<!-- //                 node3dDepthDistance: 300, -->

<!-- //                 // If set to true, the animation will rotate. Default: false -->
<!-- //                 node3dRotate: false, -->

<!-- //                 // If node3dRotate is set to true, the following option indicate if rotation should pause between n restNodeMovements. Default: 1 -->
<!-- //                 node3dRotateOnNthNodeMovement: 1, -->

<!-- //                 // If node3dRotate is set to true, the following option indicate the alpha of the nodes at the far end of the rotation, creating depth. Default: 0.1 -->
<!-- //                 node3dRotateDepthAlpha: 0.1, -->

<!-- //                 // If node3dRotate is set to true, the following option indicates the ease mode of each node movement (linear, easeIn, easeOut, easeInOut, accelerateDecelerate). Default: linear -->
<!-- //                 node3dRotatEase: "linear", -->

<!-- //                 // If node3dRotate is set to true, the following option indicate the axis on the canvas around which the animation will rotate (median, center, left, right). Default: center -->
<!-- //                 node3dRotateAxis: "center", -->

<!-- //                 // Indicates how many nodes to paint which relation can be filled (note: nodeFillSapce must be set to true).  -->
<!-- //                 numberOfNodes: 15, -->

<!-- //                 // Indicates how many nodes to paint that does not create relations that can be filled.  -->
<!-- //                 numberOfUnconnectedNode: 25, -->

<!-- //                 // Indicates if a line should be drawn between the drawn between unconnected nodes.  -->
<!-- //                 ConnectUnconnectedNodes: true, -->

<!-- //                 // Indicates the maximum distance between unconnected nodes to draw the line. -->
<!-- //                 ConnectUnconnectedNodesDistance: 250, -->

<!-- //                 // Indicates the maximum painted size of each node's "dot". -->
<!-- //                 nodeDotSize: 2.5, -->

<!-- //                 // Indicates the ease mode of each node movement (linear, easeIn, easeOut, easeInOut, accelerateDecelerate).  -->
<!-- //                 nodeEase: "easeOut", -->

<!-- //                 // If true, the nodes starting position will descend into place on load.  -->
<!-- //                 nodeFancyEntrance: false, -->

<!-- //                 // If true, each nodes starting position will be randomized within the canvas size. If false, each nodes position must be specified manually.  -->
<!-- //                 randomizePolygonMeshNetworkFormation: true, -->

<!-- //                 // Indicates the positioning of each nodes starting position (note: randomizePolygonMeshNetworkFormation must be set to false). -->
<!-- //                 specifyPolygonMeshNetworkFormation: null, -->

<!-- //                 // Indicates how many nodes of the "numberOfNodes" that will be connected. -->
<!-- //                 nodeRelations: 3, -->

<!-- //                  Indicates the frame rate at which to up<a href="https://www.jqueryscript.net/time-clock/">date</a> each node movement. -->
<!-- //                 animationFps: 30, -->

<!-- //                 // Indicates the color (RGB) of each node's "dot".  -->
<!-- //                 nodeDotColor: "255, 255, 255", -->

<!-- //                 // If nodeDotColor is set to an array of colors, this option indicates in what order to pick the colors (linear or random). Default: linear -->
<!-- //                 nodeDotColoringSchema: "linear", -->

<!-- //                 // Indicates the color (RGB) of the line drawn between connected nodes. -->
<!-- //                 nodeLineColor: "255, 255, 255", -->

<!-- //                 // If nodeLineColor is set to an array of colors, this option indicates in what order to pick the colors (linear or random). Default: linear -->
<!-- //                 nodeLineColoringSchema: "linear", -->

<!-- //                 // Indicates the fill color (RGB) between each connected node.  -->
<!-- //                 nodeFillColor: "255, 255, 255", -->

<!-- //                 // If nodeFillColor is set to an array of colors, this option indicates in what order to pick the colors (linear or random). Default: linear -->
<!-- //                 nodeFillColoringSchema: "linear", -->

<!-- //                 // Indicates the linear gradient to the fill color (RGB) between each connected node.  -->
<!-- //                 nodeFillGradientColor: null, -->

<!-- //                 // If nodeFillGradientColor is set to an array of colors, this option indicates in what order to pick the colors (linear or random). Default: linear -->
<!-- //                 nodeFillGradientColoringSchema: "linear", -->

<!-- //                 // Indicates the fill color's alpha level (1-0). -->
<!-- //                 nodeFillAlpha: 0.5, -->

<!-- //                 // Indicates the alpha level (1-0) of the line drawn between connected nodes.  -->
<!-- //                 nodeLineAlpha: 0.5, -->

<!-- //                 // Indicates the alpha level (1-0) of each node's "dot".  -->
<!-- //                 nodeDotAlpha: 1.0, -->

<!-- //                 // Indicates the probability (1-0) of showing the coordinates for each nodes final position. -->
<!-- //                 nodeDotPrediction: 0, -->

<!-- //                 // If true, the relation between connected nodes will be filled.  -->
<!-- //                 nodeFillSapce: true, -->

<!-- //                 // If true, each node's final position can be outside the canvas boundary.  -->
<!-- //                 nodeOverflow: true, -->

<!-- //                 // If true, a glowing effect is added to each node, its relations and fill respectively. -->
<!-- //                 nodeGlowing: false, -->

<!-- //                 // Indicates the width of the canvas on which to paint each node.  -->
<!-- //                 canvasWidth: $(this).width(), -->

<!-- //                 // Indicates the height of the canvas on which to paint each node. -->
<!-- //                 canvasHeight: $(this).height(), -->

<!-- //                 // Indicate the CSS position property by which to position the canvas. -->
<!-- //                 canvasPosition: "absolute", -->

<!-- //                 // Indicate the CSS top property by which to vertically position the canvas. -->
<!-- //                 canvasTop: "auto", -->

<!-- //                 // Indicate the CSS bottom property by which to vertically position the canvas. -->
<!-- //                 canvasBottom: "auto", -->

<!-- //                 // Indicate the CSS right property by which to horizontally position the canvas. -->
<!-- //                 canvasRight: "auto", -->

<!-- //                 // Indicate the CSS left property by which to horizontally position the canvas. -->
<!-- //                 canvasLeft: "auto", -->

<!-- //                 // Indicate the CSS z-index property by which to specify the stack order of the canvas. -->
<!-- //                 canvasZ: "auto" -->

<!-- //             }); -->
<!-- <!--     </script> --> -->
    
       <!-- background 2 -->
    		<div id="background"></div>
    <script>
        // As A JavaScript Plugin
            document.addEventListener('DOMContentLoaded', function () {
                daisyjs(document.getElementById('background'), {
                    // options here
                });
            }, false);

            // As A jQuery Plugin
            $(document).ready(function () {
                $('#background').daisyjs({
                    // options here
                });
            });
    </script>
</body>
</html>