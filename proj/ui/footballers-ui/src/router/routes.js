import UrlPath from "../constans/UrlPath";
import TeamsPage from "../pages/TeamsPage";
import PlayersPage from "../pages/PlayersPage";

export const routes = [
    {path: UrlPath.Teams, element: <TeamsPage/>, exact: true},
    {path: UrlPath.Players, element: <PlayersPage/>, exact: true}
]